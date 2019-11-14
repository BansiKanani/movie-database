package com.brk.mdb.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@OneToMany(mappedBy = "production", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Movie> movies;

	public Production(String name) {
		this.name = name;
		this.movies = new ArrayList<>();
	}

	public Production() {
		super();
		// TODO Auto-generated constructor stub
	}
}