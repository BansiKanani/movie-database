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
public class Production {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;
	
	@OneToMany(mappedBy = "production")
	private Set<Movie> movies;

	public Production(String name) {
		super();
		this.name = name;
	}
}