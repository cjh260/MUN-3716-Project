/**
 * COMP 3716 Final Project: Inventory.java
 * 
 * Group 8:
 *  - Chris Babstock (200152353)
 *  - Stephen Brinson (200838720)
 *  - Jarret Kolanko (200858181)
 *  - Christopher Healey (201034766)
 */
package player;

import java.util.Iterator;
import java.util.Map.Entry;

/**
 * @author Group 8
 */
public class Inventory {

	/**
	 * Player's inventory.
	 */
	private InventoryMap inventory;

	/**
	 * Default contstructor. Create a new empty inventory.
	 */
	public Inventory() {
		this.inventory = new InventoryMap();
	}

	/**
	 * Get the quantity of a particular Item in player's inventory.
	 * 
	 * @param item
	 *            Item to query for
	 * @return quantity of item in inventory
	 */
	public int getItem(Item item) {
		if (inventory.containsKey(item))
			return inventory.get(item);
		return 0;
	}

	/**
	 * Get an interable list of all items in the player's inventory.
	 * 
	 * @return iterable list of InventoryMapEntry objects
	 */
	public Iterator<Entry<Item, Integer>> getAllItems() {
		return inventory.entrySet().iterator();
	}

	/**
	 * Add an item to the player's inventory. If the item already exists, then
	 * add to its current quantity.
	 * 
	 * @param item
	 *            Item to add to inventory
	 * @param quantity
	 *            quantity of Item to add to inventory
	 * @return quantity of item in inventory after addition
	 */
	public int addItem(Item item, Integer quantity) {
		int qty = quantity;
		if (inventory.containsKey(item))
			qty = qty + inventory.get(item);
		inventory.put(item, qty);
		return quantity;
	}

	/**
	 * Remove a given quantity of an Item from player's inventory.
	 * 
	 * @param item
	 *            Item to be removed from inventory
	 * @param quantity
	 *            quantity of Item to remove from inventory
	 * @return quantity of items remaining after removal
	 */
	public int removeItem(Item item, Integer quantity) {
		int qty = quantity;
		if (inventory.containsKey(item)) {
			int old = inventory.get(item);
			if (old >= qty) {
				inventory.put(item, (old - qty));
				return (old - qty);
			}
			return old; // Not enough items to remove
		}
		return 0; // No items to remove
	}

	/**
	 * Remove all instances of an item from a player's inventory.
	 * 
	 * @param item
	 *            item to completely remove from inventory
	 * @return quantity of item removed from inventory
	 */
	public int removeAllOfItem(Item item) {
		if (inventory.containsKey(item)) {
			int quantity = inventory.get(item);
			inventory.remove(item);
			return quantity;
		}
		return 0;
	}

	/**
	 * Clear all items from inventory and return iterable list of items removed.
	 * 
	 * @return iterable list of InventoryMapEntry objects
	 */
	public Iterator<Entry<Item, Integer>> removeAllItems() {
		Iterator<Entry<Item, Integer>> itr = inventory.entrySet().iterator();
		inventory.clear();
		return itr;
	}

	public String toString() {
		String msg = "";
		for (Entry<Item, Integer> s : inventory.entrySet()) {
			msg += s.getKey() + ": " + s.getValue() + "\n";
		}

		if (msg.equalsIgnoreCase(""))
			return "Inventory is empty.";
		return msg;
	}
}
