package com.piedaholic.oops.designs.abstraction;

public abstract class AbstractA {

	public AbstractA() {
		System.out.println("Inside Abstract Class Constructor");
	}

	// Unimplemented Method
	public abstract void peek();

	public static void walk() {
		System.out.println("AbstractA::walk()");
	}

	public void mate() {
		System.out.println("AbstractA::mate()");
	}

	public void run() {
		System.out.println("AbstractA::run()");
	}
}
