package com.brk.mdb.models;

import java.util.Set;

import javax.persistence.Entity;
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

	@ManyToMany(mappedBy = "languages")
	private Set<Movie> movies;

	public Language(String name) {
		super();
		this.name = name;
	}
}