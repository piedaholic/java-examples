package com.piedaholic.oops.designs.abstraction;

public class ClassA extends AbstractA {

	public ClassA() {
		System.out.println("Inside class A's constructor");
	}

	public static void main(String... args) {
		AbstractA absA = new ClassA();
		absA.mate();
		absA.peek();
		
		// static method
		absA.walk();
		
		absA.run();
	}

	@Override
	public void mate() {
		System.out.println("ClassA::mate()");
	}

	@Override
	public void peek() {
		System.out.println("ClassA::peek()");
	}

}
