package com.user.entity;

public class Contact {
	
	private long cId;
	private String emmailId;
	private String contactName;
	
	private long userId;

	public Contact(long cId, String emmailId, String contactName, long userId) {
		super();
		this.cId = cId;
		this.emmailId = emmailId;
		this.contactName = contactName;
		this.userId = userId;
	}

	public Contact() {
		super();
	}

	public long getcId() {
		return cId;
	}
}
