package game;

import java.awt.Polygon;
import java.util.Iterator;

import board.Territory;
import player.Player;

public interface GameControllerInterface {
    
    public void selectPolygon(Polygon p);
    public void togglePolygon(Polygon p);
    public void setActivePlayer(Player p);
    public Player getActivePlayer();
    public void addPlayerToMap(Player p);
    public Territory getSelectedTerritory();
    public Iterator<Territory> getTerritoryNeighbors(Territory t);
    public void movePlayer(Player p, Territory to) throws UnsupportedOperationException;
    public Iterator<Territory> getTerritories();
    
    public void quitGame();
}
