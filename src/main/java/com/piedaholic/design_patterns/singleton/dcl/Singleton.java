package com.piedaholic.design_patterns.singleton.dcl;

public class Singleton {

	private static Singleton instance;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (instance == null) {
			// Thread-Safe
			synchronized (instance) {
				// Check Again before creating a new object as some other
				// thread could have reached above step
				if (instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}

}
