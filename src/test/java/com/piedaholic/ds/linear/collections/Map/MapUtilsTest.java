/**
 * 
 */
package com.piedaholic.ds.linear.collections.Map;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

import com.piedaholic.models.Employee;

/**
 * @author HPSINGH
 *
 */
public class MapUtilsTest {

	/**
	 * Test method for
	 * {@link com.piedaholic.ds.linear.collections.Map.MapUtils#sortByValue(java.util.Map)}.
	 */

	@Test
	public void testSortByValue() {
		StringBuilder sb = new StringBuilder();
		sb.appendCodePoint(99);
		System.err.println(sb.toString());
		Map<String, Employee> map = new HashMap<>();
		Random random = new Random();
		random.ints().limit(20).forEach((k) -> {
			int leftLimit = 97; // letter 'a'
			int rightLimit = 122; // letter 'z'
			int targetStringLength = 10;
			String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
			map.put(String.valueOf(k), new Employee(String.valueOf(k), generatedString, random.nextInt()));
		});

		Map<String, Employee> sortedMap = MapUtils.sortByValue(map);
		assertTrue(sortedMap.size()>0);
		sortedMap.forEach((k, v) -> {
			System.out.println(k + " " + v.toString());
		});
	}

}
