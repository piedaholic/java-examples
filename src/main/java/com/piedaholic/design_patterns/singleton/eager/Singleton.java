package com.piedaholic.design_patterns.singleton.eager;

public class Singleton {
	private final static Singleton instance = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return instance;
	}

}
