/**
 * COMP 3716 Final Project: Item.java
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
/**
 * @author Group 8
 * List of valid items a character can obtain
 */
public enum Item {
	SHEEP,
	MONEY,
	WATER,
	GOLD,
	WOOD;
	/**
	 * @return   list of all valid items a player can obtain
	 */
	public static List<Item> getValues() {
		return Arrays.asList(Item.values());
	}
}
