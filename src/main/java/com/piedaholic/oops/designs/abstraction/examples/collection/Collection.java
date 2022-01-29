/**
 * 
 */
package com.piedaholic.oops.designs.abstraction.examples.collection;

/**
 * @author HPSINGH
 *
 */
public interface Collection<T> extends Iterable<T>{
	
	default void stream() {
		System.out.println("Implementation in Collection Interface");
	}
	
	@Override
	default int spliterator() {
		// TODO Auto-generated method stub
		// return Iterable.super.spliterator();
		return 2;
	} 
	
	boolean add(T data);
	boolean remove(T data);
	void clear();
	int size();

}
