package com.brk.mdb.models;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String name;
	private int length;
	
	@ManyToOne
	private User madeby;

	public Movie(String name, int length, User madeby) {
		super();	
		this.name = name;
		this.length = length;
		this.madeby = madeby;
	}
}
