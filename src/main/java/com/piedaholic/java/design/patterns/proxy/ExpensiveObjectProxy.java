package com.piedaholic.java.design.patterns.proxy;

import com.piedaholic.annotations.Runner;

@Runner
public class ExpensiveObjectProxy implements ExpensiveObject {

	private static ExpensiveObject object;

	@Override
	public void process() {
		if (object == null)
			object = new ExpensiveObjectImpl();
		object.process();
		object.process();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExpensiveObject proxy = new ExpensiveObjectProxy();
		proxy.process();
	}

}
