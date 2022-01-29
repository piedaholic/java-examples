/**
 * 
 */
package com.piedaholic.java.design.patterns.proxy;

/**
 * @author HPSINGH
 *
 */
public class ExpensiveObjectImpl implements ExpensiveObject {

	/**
	 * 
	 */
	public ExpensiveObjectImpl() {
		super();
		heavyConfig();
	}

	private void heavyConfig() {
		System.out.println("ExpensiveObjectImpl::heavyConfig()");
	}

	@Override
	public void process() {
		System.out.println("ExpensiveObjectImpl::process()");
	}

}
