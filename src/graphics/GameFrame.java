package graphics;

import game.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Polygon;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import player.Player;
import board.Territory;

public class GameFrame extends JFrame implements GameViewInterface {
    
    private GameControllerInterface controller;
    private GameModelInterface model;
    private JPanel insidePanel;
    private MapPanel mapPanel;
    private CharacterPanel playerPanel;
    private TerritoryPanel countryPanel;
    private ActionBar actionsPanel;
    private JSeparator vsep;
    private JSeparator hsep, hsep2;
    private CreatePlayerFrame newPlayer;
    
    public GameFrame(GameControllerInterface c, GameModelInterface m) {
        this.controller = c;
        this.model = m;
        
        newPlayer = new CreatePlayerFrame(this,c,m);
        newPlayer.setVisible(true);
        
        initialize();
    }
    
    private void initialize() {
  
        mapPanel = new MapPanel(controller, model);
        
        playerPanel = new CharacterPanel(controller, model);
        countryPanel = new TerritoryPanel(controller, model);
        actionsPanel = new ActionBar(controller, model);
        
        vsep = new JSeparator(JSeparator.VERTICAL);
        vsep.setPreferredSize(new Dimension(5,1));
        
        hsep = new JSeparator(JSeparator.HORIZONTAL);
        hsep.setPreferredSize(new Dimension(1,5));
        
        hsep2 = new JSeparator(JSeparator.HORIZONTAL);
        hsep2.setPreferredSize(new Dimension(1,5));
        
        insidePanel = new JPanel();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
                
        insidePanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 3;
        c.weighty = 1;
        insidePanel.add(mapPanel, c);
        
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 3;
        c.weighty = 1;
        insidePanel.add(vsep, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 1;
        insidePanel.add(playerPanel, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 1;
        insidePanel.add(hsep, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        insidePanel.add(countryPanel, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 3;
        c.weighty = 1;
        insidePanel.add(hsep2, c);
     
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.gridheight = 1;
        c.gridwidth = 3;
        c.weighty = 1;
        insidePanel.add(actionsPanel, c);
        
        this.add(insidePanel);
        
        pack();
    }

    @Override
    public void setPolygons(List<Polygon> polys) {
        mapPanel.setPolygons(polys);
    }

    @Override
    public void setMapBackground(Image i) {
        mapPanel.setBackgroundImage(i);
        
    }

    @Override
    public void updateTerritoryView(Territory t) {
        countryPanel.update(t);
    }

    @Override
    public void updatePlayerView(Player p) {
        playerPanel.update(p);
    }

    @Override
    public void quitGame() {
        this.dispose();
    }

    @Override
    public void togglePolygon(Polygon p) {
        mapPanel.togglePolygon(p);
    }

}
