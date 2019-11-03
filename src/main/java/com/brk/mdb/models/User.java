package com.brk.mdb.models;

import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Data
@Entity(name = "Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;
	private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<MovieReview> movieReviews;
	
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
}