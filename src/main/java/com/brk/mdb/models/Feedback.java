package com.brk.mdb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String message;

	public Feedback(User user, String message) {
		this.user = user;
		this.message = message;
	}

	public Feedback() {
		super();
	}
}