/**
 * 
 */
package com.piedaholic.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.piedaholic.streams.RandomDataGenerator;

/**
 * @author HPSINGH
 *
 */
public class EmployeeTest {
	static List<Employee> li = new ArrayList<>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		List<String> idList = Stream.generate(() -> {
			return RandomDataGenerator.generateRandomNumericIdString(5);
		}).limit(10).collect(Collectors.toList());
		List<String> namesList = Stream.generate(RandomDataGenerator::generateRandomCamelCaseString).limit(10)
				.collect(Collectors.toList());
		List<Long> salaryList = new Random().longs(10, 50000, 500000).boxed().collect(Collectors.toList());
		int ctr = 0;
		while (ctr < 10) {
			li.add(new Employee(idList.get(ctr), namesList.get(ctr), salaryList.get(ctr)));
			ctr++;
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		li.stream().collect(Collectors.groupingBy(Employee::getId, Collectors.counting())).forEach((k, v) -> {
			System.out.println(k + " " + v);
		});
		li.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting())).forEach((k, v) -> {
			System.out.println(k + " " + v);
		});
		li.stream().sorted((e1, e2) -> {
			return e1.getId().compareTo(e2.getId());
		}).forEach((k) -> {
			System.out.println(k.getId() + " " + k.getEmpName() + " " + k.getSalary());
		});
		System.out.println(li.stream().mapToLong(e -> e.getSalary()).average());
		System.out.println(li.stream().mapToLong(e -> e.getSalary()).sum());
	}

}
