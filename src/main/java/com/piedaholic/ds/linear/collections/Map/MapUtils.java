/**
 * 
 */
package com.piedaholic.ds.linear.collections.Map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author HPSINGH
 *
 */
public class MapUtils {
	public static <K, V extends Comparable<V>> Map<K, V> sortByValue(Map<K, V> map) {
		Comparator<K> valueComp = new Comparator<K>() {
			@Override
			public int compare(K k1, K k2) {
				return map.get(k1).compareTo(map.get(k2));
			}
		};
		Map<K, V> result = new TreeMap<K, V>(valueComp);
		result.putAll(map);
		return result;
	}
}
