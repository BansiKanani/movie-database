package com.brk.mdb.modelsTO;

import com.brk.mdb.models.Feedback;

import lombok.Data;

@Data
public class FeedbackTO {

	private long id;
	private UserTO user;
	private String message;

	public FeedbackTO(Feedback f) {
		this.id = f.getId();
		this.user = new UserTO(f.getUser());
		this.message = f.getMessage();
	}

	public FeedbackTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FeedbackTO [id=" + id + ", user=" + user + ", message=" + message + "]";
	}
}