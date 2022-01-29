/**
 * 
 */
package com.piedaholic.oops.designs.abstraction.examples.collection;

/**
 * @author HPSINGH
 *
 */
@com.piedaholic.annotations.Runner
public class Runner {
	public static void main(String... args) {
		List<String> li = new ListImpl<String>();
		li.add(null);
		li.remove(null);
		System.out.println("List Imple");
	}
}
