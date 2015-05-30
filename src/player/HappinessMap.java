/*** COMP 3716 Final Project: HappinessMap.java
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
 *         <Happiness.HappinessType,List<Integer>> pair
 */
public class HappinessMap implements
		Map<Happiness.HappinessType, List<Integer>> {
	private List<HappinessMap.Entry> happy;

	/**
	 * Default constructor.
	 */
	public HappinessMap() {
		this.happy = new ArrayList<HappinessMap.Entry>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#clear()
	 */
	@Override
	public void clear() {
		this.happy = new ArrayList<HappinessMap.Entry>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object arg0) {
		for (Iterator<Entry> i = happy.iterator(); i.hasNext();) {
			if (i.next().getKey() == (Happiness.HappinessType) arg0) {
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
		for (Iterator<Entry> i = happy.iterator(); i.hasNext();) {
			if (i.next().getValue() == (List<Integer>) arg0) {
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
	public Set<java.util.Map.Entry<Happiness.HappinessType, List<Integer>>> entrySet() {
		return new HashSet<java.util.Map.Entry<Happiness.HappinessType, List<Integer>>>(
				happy);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#get(java.lang.Object)
	 */
	@Override
	public List<Integer> get(Object arg0) {
		for (Iterator<Entry> i = happy.iterator(); i.hasNext();) {
			HappinessMap.Entry entry = i.next();
			if (entry.getKey() == (Happiness.HappinessType) arg0) {
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
	public Set<Happiness.HappinessType> keySet() {
		Set<Happiness.HappinessType> set = new HashSet<Happiness.HappinessType>();
		for (Iterator<Entry> i = happy.iterator(); i.hasNext();) {
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
	public List<Integer> put(Happiness.HappinessType arg0, List<Integer> arg1) {
		HappinessMap.Entry entry;
		for (Iterator<Entry> i = happy.iterator(); i.hasNext();) {
			entry = i.next();
			if (entry.getKey() == arg0) {
				List<Integer> old = entry.getValue();
				entry.setValue(arg1);
				return old;
			}
		}
		happy.add(new HappinessMap.Entry(arg0, arg1));
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	@Override
	public void putAll(
			Map<? extends Happiness.HappinessType, ? extends List<Integer>> arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	@Override
	public List<Integer> remove(Object arg0) {
		HappinessMap.Entry entry;
		for (Iterator<Entry> i = happy.iterator(); i.hasNext();) {
			entry = i.next();
			if (entry.getKey() == (Happiness.HappinessType) arg0) {
				List<Integer> old = entry.getValue();
				happy.remove(entry);
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
		return happy.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#values()
	 */
	@Override
	public Collection<List<Integer>> values() {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (Iterator<Entry> i = happy.iterator(); i.hasNext();) {
			list.add(i.next().getValue());
		}
		return list;
	}

	/**
	 * @author Chris Babstock
	 * 
	 */
	class Entry implements Map.Entry<Happiness.HappinessType, List<Integer>> {

		private Happiness.HappinessType key;
		private List<Integer> value;

		/**
		 * @param arg0
		 * @param arg1
		 */
		public Entry(Happiness.HappinessType arg0, List<Integer> arg1) {
			key = arg0;
			value = arg1;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map.Entry#getKey()
		 */
		@Override
		public Happiness.HappinessType getKey() {
			return key;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map.Entry#getValue()
		 */
		@Override
		public List<Integer> getValue() {
			return value;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map.Entry#setValue(java.lang.Object)
		 */
		@Override
		public List<Integer> setValue(List<Integer> value) {
			List<Integer> old = value;
			this.value = value;
			return old;
		}
	}
}
