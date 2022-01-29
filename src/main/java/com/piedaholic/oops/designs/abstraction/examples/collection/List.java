/**
 * 
 */
package com.piedaholic.oops.designs.abstraction.examples.collection;

/**
 * @author HPSINGH
 *
 */
public interface List<T> extends Collection<T> {

	default int spliterator() {
		return 3;
	};
	
	boolean addAtIdx(int idx, T data);
	boolean removeAtIdx(int idx);
}
