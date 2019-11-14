package com.brk.mdb.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;

	@ManyToMany(mappedBy = "languages", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Movie> movies;

	public Language(String name) {
		this.name = name;
		this.movies = new ArrayList<>();
	}

	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}
}