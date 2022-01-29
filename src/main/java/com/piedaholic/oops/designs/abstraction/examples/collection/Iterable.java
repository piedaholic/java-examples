/**
 * 
 */
package com.piedaholic.oops.designs.abstraction.examples.collection;

/**
 * @author HPSINGH
 *
 */
public interface Iterable<T> {
	
	int iterator();
	
	default int spliterator() {
		System.out.println("Iterable Interface Implementation");
		return 1;
	}

}
