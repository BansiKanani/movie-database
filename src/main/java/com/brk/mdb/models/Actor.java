package com.brk.mdb.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;

	private int height;
	
	private String city;
	private String state;
	private String country;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@ManyToMany(mappedBy = "actors")
	private List<Movie> movies;

	public Actor(String name, int height, String city, String state, String country, Date dob) {
		super();
		this.name = name;
		this.height = height;
		this.city = city;
		this.state = state;
		this.country = country;
		this.dob = dob;
		this.movies = new ArrayList<>();;
	}

	public Actor() {
		super();
	}
}