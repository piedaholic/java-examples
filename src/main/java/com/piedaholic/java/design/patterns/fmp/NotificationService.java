package com.piedaholic.java.design.patterns.fmp;

public class NotificationService<T> {
	private Notification<T> notification;

	public NotificationService(String medium) {
		this.notification = NotificationFactory.getNotificationMedium(medium);
	}

	public void  send(T data) {
		this.notification.send(data);
	}

}
