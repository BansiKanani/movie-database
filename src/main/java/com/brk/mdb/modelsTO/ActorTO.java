package com.brk.mdb.modelsTO;

import java.util.Date;
import java.util.Set;

public class ActorTO {

	private long id;
	private String name;
	private int height;
	private String city;
	private String state;
	private String country;
	private Date dob;
	private Set<long> moviesId;

	public ActorTO(String name, int height, String city, String state, String country, Date dob, Set<MovieTO> movies) {
		super();
		this.name = name;
		this.height = height;
		this.city = city;
		this.state = state;
		this.country = country;
		this.dob = dob;
		this.movies = movies;
	}

}