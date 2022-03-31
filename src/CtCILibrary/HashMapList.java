package CtCILibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * The HashMapList program implemented in Java for learning purposes.
 *
 * A HashMapList class is essentially shorthand for HashMap<T, ArrayList<E>>. It allows us to map from an item of type T
 * to an ArrayList of type E.
 *
 * @author Evanthios Papadopoulos
 * @since 31-Mar-22
 **/

public class HashMapList<T, E> {
    private final HashMap<T, ArrayList<E>> map = new HashMap<>();

    // Insert item into list at key.
    public void put (T key, E item) {
        if ((!map.containsKey(key))) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(item);
    }

    // Insert list of items at key.
    public void put(T key, ArrayList<E> items) {
        map.put(key, items);
    }

    // Get list of items at key.
    public ArrayList<E> get(T key) {
        return map.get(key);
    }

    // Check if hashmaplist contains key.
    public boolean containsKey(T key) {
        return map.containsKey(key);
    }

    // Check if list at key contains value.
    public boolean containsKeyValue(T key, E value) {
        ArrayList<E> list = get(key);
        if (list == null) return false;
        return list.contains(value);
    }

    // Get the list of keys.
    public Set<T> keySet() {
        return map.keySet();
    }

    @Override
    public String toString() {
        return map.toString();
    }

}
