/*** COMP 3716 Final Project: InventoryMap.java
 * 
 * Group 8:
 *  - Chris Babstock (200152353)
 *  - Stephen Brinson (200838720)
 *  - Jarret Kolanko (200858181)
 *  - Christopher Healey (201034766)
 */
package player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Group 8 Implementation of the java.util.Map interface using an
 *         <Item,Integer> pair
 */
public class InventoryMap implements Map<Item, Integer> {
	private List<InventoryMap.Entry> items;

	/**
	 * Default constructor.
	 */
	public InventoryMap() {
		this.items = new ArrayList<InventoryMap.Entry>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#clear()
	 */
	@Override
	public void clear() {
		this.items = new ArrayList<InventoryMap.Entry>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object arg0) {
		for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
			if (i.next().getKey() == (Item) arg0) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object arg0) {
		for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
			if (i.next().getValue() == (Integer) arg0) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#entrySet()
	 */
	@Override
	public Set<java.util.Map.Entry<Item, Integer>> entrySet() {
		return new HashSet<java.util.Map.Entry<Item, Integer>>(items);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#get(java.lang.Object)
	 */
	@Override
	public Integer get(Object arg0) {
		for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
			InventoryMap.Entry entry = i.next();
			if (entry.getKey() == (Item) arg0) {
				return entry.getValue();
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#keySet()
	 */
	@Override
	public Set<Item> keySet() {
		Set<Item> set = new HashSet<Item>();
		for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
			set.add(i.next().getKey());
		}
		return set;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer put(Item arg0, Integer arg1) {
		InventoryMap.Entry entry;
		for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
			entry = i.next();
			if (entry.getKey() == arg0) {
				Integer old = entry.getValue();
				entry.setValue(arg1);
				return old;
			}
		}
		items.add(new InventoryMap.Entry(arg0, arg1));
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<? extends Item, ? extends Integer> arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	@Override
	public Integer remove(Object arg0) {
		InventoryMap.Entry entry;
		for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
			entry = i.next();
			if (entry.getKey() == (Item) arg0) {
				Integer old = entry.getValue();
				items.remove(entry);
				return old;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#size()
	 */
	@Override
	public int size() {
		return items.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#values()
	 */
	@Override
	public Collection<Integer> values() {
		List<Integer> list = new ArrayList<Integer>();
		for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
			list.add(i.next().getValue());
		}
		return list;
	}

	/**
	 * @author Chris Babstock
	 * 
	 */
	public class Entry implements Map.Entry<Item, Integer> {

		private Item key;
		private int value;

		/**
		 * @param arg0
		 * @param arg1
		 */
		public Entry(Item arg0, Integer arg1) {
			key = arg0;
			value = arg1;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map.Entry#getKey()
		 */
		@Override
		public Item getKey() {
			return key;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map.Entry#getValue()
		 */
		@Override
		public Integer getValue() {
			return value;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map.Entry#setValue(java.lang.Object)
		 */
		@Override
		public Integer setValue(Integer value) {
			Integer old = value;
			this.value = value;
			return old;
		}
	}
}
