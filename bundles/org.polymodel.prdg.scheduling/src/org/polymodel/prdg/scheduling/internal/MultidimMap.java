package org.polymodel.prdg.scheduling.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Multidimensionnal map utility.
 * 
 * @author antoine
 * 
 * @param <K>
 *            Key type of the map
 * @param <V>
 *            Value type of the map
 */
public class MultidimMap<K, V> {
	private Map<K, Map<Integer, V>> map = new HashMap<K, Map<Integer, V>>();

	/**
	 * Get the value of a key for a given dimension.
	 * 
	 * @param dim
	 * @param key
	 * @return
	 */
	public V get(int dim, K key) {
		Map<Integer, V> values = getValuesMap(key);
		return values.get(dim);
	}

	private Map<Integer, V> getValuesMap(K key) {
		Map<Integer, V> values = map.get(key);
		if (values == null) {
			values = new HashMap<Integer, V>();
			map.put(key, values);
		}
		return values;
	}

	/**
	 * Put the value of a key for a given dimension.
	 * 
	 * @param dim
	 * @param key
	 * @param value
	 */
	public void put(int dim, K key, V value) {
		Map<Integer, V> values = getValuesMap(key);
		values.put(dim, value);
	}

	/**
	 * Get values of all dimensions for a key.
	 * 
	 * @param key
	 * @return List of values for key
	 */
	public List<V> getAllValues(K key) {
		List<V> values = new ArrayList<V>();
		Set<Entry<Integer, V>> entrySet = getValuesMap(key).entrySet();
		for (Entry<Integer, V> entry : entrySet) {
			values.add(entry.getValue());
		}
		return values;
	}
}