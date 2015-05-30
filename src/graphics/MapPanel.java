package graphics;

import game.*;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;

public class MapPanel extends JPanel implements MouseListener {

    private Image image;
    private List<Polygon> zones;
    private Color fill;
    private float alpha;
    private int currentMap;
    private GameControllerInterface controller;
    private GameModelInterface model;

    public MapPanel(GameControllerInterface c, GameModelInterface m) {
        this.controller = c;
        this.model = m;
    	addMouseListener(this);
    	currentMap = -1;
        alpha = 0.2f;
        fill = Color.YELLOW;
        initialize();
    }
    
    private void initialize() {
        this.setPreferredSize(new Dimension(900, 600));
    }
    
    void setBackgroundImage(Image i) {
        this.image = i;
        repaint();
    }

    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.image, 0, 0, this);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, this.alpha));
        g2.setColor(this.fill);
        if(this.currentMap > -1)
            g2.fillPolygon(this.zones.get(this.currentMap));
    }
    
    private void setFill(Color color, float alpha){
        this.fill = color;
        this.alpha = alpha;
    }
    
    void setPolygons(List<Polygon> polys) {
        this.zones = polys;
    }
    
    void togglePolygon(Polygon p) {
        for (int i=0; i<zones.size(); i++){
            if(zones.get(i) == p){
                this.firePropertyChange("CurrentMap", currentMap, i);
                currentMap = i;
                repaint();
                break; // no need to keep checking
            }
        }   
    }
    
	@Override
	public void mouseReleased(MouseEvent arg0) {

        for (int i=0; i<zones.size(); i++){
            if(zones.get(i).contains(arg0.getX(), arg0.getY())){
                togglePolygon(zones.get(i));
                controller.selectPolygon(zones.get(i));
                break; // no need to keep checking
            }
        }   
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}
}
