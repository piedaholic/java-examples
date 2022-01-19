package com.piedaholic.java.design.patterns.singleton.sync;

public class Singleton {
	private static Singleton instance;
	
	private Singleton() {

	}
	
	//Only one  thread can execute this method at once
	public static synchronized Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}
}
