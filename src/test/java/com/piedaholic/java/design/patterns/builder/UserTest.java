/**
 * 
 */
package com.piedaholic.java.design.patterns.builder;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * @author HPSINGH
 *
 */
public class UserTest {

	@Test
	public void testUser() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
		Date date = sdf.parse("14-06-1994");
		User user = new User.UserBuilder("HPSINGH", "1", date, "M").withEmail("hh").build();
		assertTrue(!user.toString().isEmpty());
	}

}
