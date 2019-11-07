package com.brk.mdb.modelsTO;

import com.brk.mdb.models.Feedback;

import lombok.Data;

@Data
public class FeedbackTO {

	private long id;
	private UserTO user;
	private String message;
	
	public FeedbackTO(Feedback f) {
		super();
		this.user = new UserTO(f.getUser());
		this.message = f.getMessage();
	}
}