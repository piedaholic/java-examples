/**
 * 
 */
package com.piedaholic.java.design.patterns.fmp;

/**
 * @author HPSINGH
 *
 */
public class Email<T> implements Notification<T> {

	@Override
	public void send(T data) {
		System.out.println("Sending Email");
	}

}
