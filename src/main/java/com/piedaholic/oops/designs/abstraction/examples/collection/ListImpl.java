/**
 * 
 */
package com.piedaholic.oops.designs.abstraction.examples.collection;

/**
 * @author HPSINGH
 *
 */
public class ListImpl<T> extends AbstractList<T>
//Redundant Part Starts
		/*
		 * Java also implements List in its list implementations for documentation
		 * purposes probably. This is totally redundant.
		 */
		// implements List<T>
		/*-
		Redundant superinterface List<T> for the type ListImpl<T>, already defined by AbstractList<T>
		*/
		//Redundant Part Ends
{

	@Override
	public boolean addAtIdx(int idx, T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAtIdx(int idx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int iterator() {
		// TODO Auto-generated method stub
		return 0;
	}

}
