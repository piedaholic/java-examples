/**
 * 
 */
package com.piedaholic.models;

import java.util.Objects;

/**
 * @author HPSINGH
 *
 */
public class Employee implements Comparable<Employee> {
	private String id;
	private String empName;
	private long salary;

	public Employee(String id, String empName, long salary) {
		super();
		this.id = id;
		this.empName = empName;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empName, id, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empName, other.empName) && Objects.equals(id, other.id) && salary == other.salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		if ((this.getSalary() - o.getSalary()) == 0L)
			return 0;
		return (this.getSalary() - o.getSalary()) > 0L ? 1 : -1;
	}

}
