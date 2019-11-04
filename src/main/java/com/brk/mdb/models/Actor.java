package com.brk.mdb.models;

import java.util.Date;
import java.util.Set;

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
	private Set<Movie> movies;

	public Actor(String name, int height, String city, String state, String country, Date dob, Set<Movie> movies) {
		super();
		this.name = name;
		this.height = height;
		this.city = city;
		this.state = state;
		this.country = country;
		this.dob = dob;
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", height=" + height + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", dob=" + dob + ", movies=" + movies + "]";
	}

}