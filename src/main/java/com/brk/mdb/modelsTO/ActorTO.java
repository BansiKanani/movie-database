package com.brk.mdb.modelsTO;

import java.util.Date;

import com.brk.mdb.models.Actor;

import lombok.Data;

@Data
public class ActorTO {

	private long id;
	private String name;
	private int height;
	private String city;
	private String state;
	private String country;
	private Date dob;

	public ActorTO(Actor a) {
		this.id = a.getId();
		this.name = a.getName();
		this.height = a.getHeight();
		this.city = a.getCity();
		this.state = a.getState();
		this.country = a.getCountry();
		this.dob = a.getDob();
	}

}