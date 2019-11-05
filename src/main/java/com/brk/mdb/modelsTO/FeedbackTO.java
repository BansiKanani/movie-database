package com.brk.mdb.modelsto;

public class FeedbackTO {

	private long id;

	private UserTO user;

	private String message;

	public FeedbackTO(UserTO user, String message) {
		super();
		this.user = user;
		this.message = message;
	}

}