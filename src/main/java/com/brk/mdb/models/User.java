package com.brk.mdb.models;

import java.util.List;

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
	
	@OneToMany
	private List<Movie> moviesmade;

	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
}