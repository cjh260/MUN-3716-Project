/**
 * COMP 3716 Final Project: Territory.java
 * 
 * Group 8:
 *  - Chris Babstock (200152353)
 *  - Stephen Brinson (200838720)
 *  - Jarret Kolanko (200858181)
 *  - Christopher Healey (201034766)
 */
package board;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import player.Player;

/**
 * Concrete representation of a territory on a 2D world map.
 * @author Group 8
 */
public class Territory implements java.io.Serializable {
	
	//region Private Variables
	/**
	 * 
	 */
	private static final long serialVersionUID = 5360937073507663827L;
	
	/**
	 * The territory's name. 
	 */
	private String name;
	
	/**
	 * List of Player objects currently residing in this geographical area
	 * of the world map.
	 */
	private List<Player> players;
	
	/**
	 * Country that owns this territory.
	 */
	private Country owner;
	
	/**
	 * List of neighboring territories that can be traveled to.
	 */
	private List<Territory> neighbors;
	//endregion Private Variables
	
	public Territory(String name) {
		this.name = name;
		players = new ArrayList<Player>();
		neighbors = new ArrayList<Territory>();
		owner = null;
	}
	
	/**
	 * Get the name of this territory.
	 * @return	name of this territory
	 */
	public String getName() { return name; }
	/**
	 * Set the name of this territory.
	 * @param name	name to give this territory
	 */
	public void setName(String name) { this.name=name; }
	/**
	 * Get the owning Country.
	 * @return	the Country object that owns the geograpical area bounded
	 * by this territory.
	 */
	public Country getCountry() { return owner; }
	/**
	 * Set the owning Country.
	 * @param country	the Country object that owns the geograpical area 
	 * bounded by this territory.
	 */
	public void setCountry (Country country) { this.owner=country; }
	/**
	 * Get a list of all Player objects currently residing in this geographical 
	 * area of the world map.
	 * @return	an Iterator over a List of Player objects
	 */
	public Iterator<Player> getPlayers() { return players.iterator(); }
	/**
	 * Adds a player to this Territory
	 * @param player	Player object to add to this Territory
	 */
	public void addPlayer(Player player) { players.add(player); }
	/**
	 * 
	 * @param player
	 */
	public void removePlayer(Player player) { players.remove(player); }
	public Integer getTotalPlayers() { return players.size(); }
	public void addNeighbor(Territory t) { neighbors.add(t); }
	public Iterator<Territory> getNeighbors() { return neighbors.iterator(); }
}
