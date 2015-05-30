package game;

import java.awt.Image;
import java.awt.Polygon;
import java.util.List;

import player.Player;
import board.Territory;

public interface GameViewInterface {

    public void setPolygons(List<Polygon> polys);
    public void setMapBackground(Image i);
    
    public void togglePolygon(Polygon p);
    
    public void updateTerritoryView(Territory t);
    public void updatePlayerView(Player p);
    
    public void quitGame();
}
