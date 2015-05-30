/**
 * COMP 3716 Final Project: Player.java
 * 
 * Group 8:
 *  - Chris Babstock (200152353)
 *  - Stephen Brinson (200838720)
 *  - Jarret Kolanko (200858181)
 *  - Christopher Healey (201034766)
 */
package player;

import java.util.Arrays;
import java.util.List;

import network.Mailbox;
import board.Country;
import board.Territory;

/**
 * @author Group 8
 * 
 */
public class Player {

	/**
	 * List of valid Player rank/types
	 * 
	 * @author Group 8
	 */
	public enum Rank {
		NOMAD, CITIZEN, OFFICIAL, LEADER, SHEEP;

		public static List<Rank> getValues() {
			return Arrays.asList(Rank.values());
		}
	}

	Country citizenship;
	Happiness happiness;
	Inventory inventory;
	String name;
	Rank rank;
	Territory inTerritory;
	Mailbox inbox;

	/**
	 * @param name
	 *            character's name
	 * @param happiness
	 *            character's happiness profile
	 */
	public Player(String name, Happiness happiness) {
		this.happiness = happiness;
		this.name = name;
		rank = Rank.NOMAD;
		inventory = new Inventory();
		this.inTerritory = null;
		this.inbox = new Mailbox(this);
	}

	/**
	 * @return character's home country
	 */
	public Country getCitizenship() {
		return citizenship;
	}

	/**
	 * @return character's happiness profile
	 */
	public Happiness getHappinessProfile() {
		return happiness;
	}

	/**
	 * @return reference to character's inventory object
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * @return character's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return character's rank
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * @param newcitizen
	 *            character's Country
	 */
	public void setCitizenship(Country newcitizen) {
		citizenship = newcitizen;
	}

	/**
	 * @param newname
	 *            character's name
	 * @return character's name
	 */
	public String setName(String newname) {
		name = newname;
		return name;
	}

	/**
	 * @param newrank
	 *            character's rank
	 */
	public void setRank(Rank newrank) {
		rank = newrank;
	}
	
	public void setLocation(Territory territory) {
		this.inTerritory = territory;
	}
	
	public Territory getLocation() {
		return inTerritory;
	}
	
	public Mailbox getMailbox() {
		return this.inbox;
	}
}
