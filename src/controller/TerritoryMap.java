package controller;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import board.Territory;

/**
 * @author Group 8 Implementation of the java.util.Map interface using an
 *         <Polygon,Territory> pair
 */
public class TerritoryMap implements Map<Polygon, Territory> {
    private List<TerritoryMap.Entry> items;

    /**
     * Default constructor.
     */
    public TerritoryMap() {
        this.items = new ArrayList<TerritoryMap.Entry>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#clear()
     */
    @Override
    public void clear() {
        this.items = new ArrayList<TerritoryMap.Entry>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#containsKey(java.lang.Object)
     */
    @Override
    public boolean containsKey(Object arg0) {
        for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
            if (i.next().getKey() == (Polygon) arg0) {
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
            if (i.next().getValue() == (Territory) arg0) {
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
    public Set<java.util.Map.Entry<Polygon, Territory>> entrySet() {
        return new HashSet<java.util.Map.Entry<Polygon, Territory>>(items);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#get(java.lang.Object)
     */
    @Override
    public Territory get(Object arg0) {
        for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
            TerritoryMap.Entry entry = i.next();
            if (entry.getKey() == (Polygon) arg0) {
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
    public Set<Polygon> keySet() {
        Set<Polygon> set = new HashSet<Polygon>();
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
    public Territory put(Polygon arg0, Territory arg1) {
        TerritoryMap.Entry entry;
        for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
            entry = i.next();
            if (entry.getKey() == arg0) {
                Territory old = entry.getValue();
                entry.setValue(arg1);
                return old;
            }
        }
        items.add(new TerritoryMap.Entry(arg0, arg1));
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#putAll(java.util.Map)
     */
    @Override
    public void putAll(Map<? extends Polygon, ? extends Territory> arg0) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#remove(java.lang.Object)
     */
    @Override
    public Territory remove(Object arg0) {
        TerritoryMap.Entry entry;
        for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
            entry = i.next();
            if (entry.getKey() == (Polygon) arg0) {
                Territory old = entry.getValue();
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
    public Collection<Territory> values() {
        List<Territory> list = new ArrayList<Territory>();
        for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
            list.add(i.next().getValue());
        }
        return list;
    }

    /**
     * @author Chris Babstock
     * 
     */
    public class Entry implements Map.Entry<Polygon, Territory> {

        private Polygon key;
        private Territory value;

        /**
         * @param arg0
         * @param arg1
         */
        public Entry(Polygon arg0, Territory arg1) {
            key = arg0;
            value = arg1;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Map.Entry#getKey()
         */
        @Override
        public Polygon getKey() {
            return key;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Map.Entry#getValue()
         */
        @Override
        public Territory getValue() {
            return value;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Map.Entry#setValue(java.lang.Object)
         */
        @Override
        public Territory setValue(Territory value) {
            Territory old = value;
            this.value = value;
            return old;
        }
    }
}
