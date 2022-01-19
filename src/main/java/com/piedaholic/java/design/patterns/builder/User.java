/**
 * 
 */
package com.piedaholic.java.design.patterns.builder;

import java.util.Date;

/**
 * @author HPSINGH
 *
 */
public class User {
	private String userId;
	private String name;
	private Date dob;
	private String gender;
	private String email;

	public User(UserBuilder ub) {
		this.userId = ub.userId;
		this.name = ub.name;
		this.dob = ub.dob;
		this.gender = ub.gender;
		this.email = ub.email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", email=" + email
				+ "]";
	}

	static class UserBuilder {
		String userId;
		String name;
		Date dob;
		String gender;
		String email;

		public UserBuilder(String userId, String id, Date dob, String gender) {
			this.userId = userId;
			this.userId = id;
			this.dob = dob;
			this.gender = gender;
		}

		public UserBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public User build() {
			return new User(this);
		}

	}

}
