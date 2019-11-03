package com.brk.mdb.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Data
@Entity
public class Director {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;
	
	@OneToMany(mappedBy = "director")
	private Set<Movie> movies;

	public Director(String name) {
		super();
		this.name = name;
	}
}