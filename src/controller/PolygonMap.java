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
 *         <Territory,Polygon> pair
 */
public class PolygonMap implements Map<Territory, Polygon> {
    private List<PolygonMap.Entry> items;

    /**
     * Default constructor.
     */
    public PolygonMap() {
        this.items = new ArrayList<PolygonMap.Entry>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#clear()
     */
    @Override
    public void clear() {
        this.items = new ArrayList<PolygonMap.Entry>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#containsKey(java.lang.Object)
     */
    @Override
    public boolean containsKey(Object arg0) {
        for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
            if (i.next().getKey() == (Territory) arg0) {
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
            if (i.next().getValue() == (Polygon) arg0) {
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
    public Set<java.util.Map.Entry<Territory, Polygon>> entrySet() {
        return new HashSet<java.util.Map.Entry<Territory, Polygon>>(items);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#get(java.lang.Object)
     */
    @Override
    public Polygon get(Object arg0) {
        for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
            PolygonMap.Entry entry = i.next();
            if (entry.getKey() == (Territory) arg0) {
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
    public Set<Territory> keySet() {
        Set<Territory> set = new HashSet<Territory>();
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
    public Polygon put(Territory arg0, Polygon arg1) {
        PolygonMap.Entry entry;
        for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
            entry = i.next();
            if (entry.getKey() == arg0) {
                Polygon old = entry.getValue();
                entry.setValue(arg1);
                return old;
            }
        }
        items.add(new PolygonMap.Entry(arg0, arg1));
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#putAll(java.util.Map)
     */
    @Override
    public void putAll(Map<? extends Territory, ? extends Polygon> arg0) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#remove(java.lang.Object)
     */
    @Override
    public Polygon remove(Object arg0) {
        PolygonMap.Entry entry;
        for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
            entry = i.next();
            if (entry.getKey() == (Territory) arg0) {
                Polygon old = entry.getValue();
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
    public Collection<Polygon> values() {
        List<Polygon> list = new ArrayList<Polygon>();
        for (Iterator<Entry> i = items.iterator(); i.hasNext();) {
            list.add(i.next().getValue());
        }
        return list;
    }

    /**
     * @author Chris Babstock
     * 
     */
    public class Entry implements Map.Entry<Territory, Polygon> {

        private Territory key;
        private Polygon value;

        /**
         * @param arg0
         * @param arg1
         */
        public Entry(Territory arg0, Polygon arg1) {
            key = arg0;
            value = arg1;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Map.Entry#getKey()
         */
        @Override
        public Territory getKey() {
            return key;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Map.Entry#getValue()
         */
        @Override
        public Polygon getValue() {
            return value;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Map.Entry#setValue(java.lang.Object)
         */
        @Override
        public Polygon setValue(Polygon value) {
            Polygon old = value;
            this.value = value;
            return old;
        }
    }
}
