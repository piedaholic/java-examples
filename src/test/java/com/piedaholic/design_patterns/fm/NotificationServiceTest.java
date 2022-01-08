/**
 * 
 */
package com.piedaholic.design_patterns.fm;

import static org.junit.Assert.*;

import org.junit.Test;

import com.piedaholic.design_patterns.fmp.NotificationService;

/**
 * @author HPSINGH
 *
 */
public class NotificationServiceTest {

	private static String msg = "Hello World!";
	
	@Test
	public void testSMS() {
		NotificationService<String> ns = new NotificationService<String>("SMS");
		ns.send(msg);
	}
	
	@Test
	public void testEmail() {
		NotificationService<String> ns = new NotificationService<String>("EMAIL");
		ns.send(msg);
	}
	
	@Test
	public void testPush() {
		NotificationService<String> ns = new NotificationService<String>("PUSH");
		ns.send(msg);
	}

}
