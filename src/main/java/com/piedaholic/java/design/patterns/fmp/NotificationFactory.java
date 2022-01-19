package com.piedaholic.java.design.patterns.fmp;

public class NotificationFactory {

	public static <T> Notification<T> getNotificationMedium(String medium) {
		if (medium.equals("SMS"))
			return new SMS<T>();
		else if (medium.equals("EMAIL")) {
			return new Email<T>();
		} else if (medium.equals("PUSH")) {
			return new Push<T>();
		}
		return null;
	}
}
