package com.piedaholic.java.design.patterns.singleton.optimal;

/**
 * 
 * @author HPSINGH This approach doesn't require synchronization, is thread
 *         safe, enforces lazy initialization and has comparatively less
 *         boilerplate.
 */
public class Singleton {

	private Singleton() {

	}

	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}

	private static class SingletonHolder {
		private static final Singleton instance = new Singleton();
	}

}
