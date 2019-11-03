package com.brk.mdb.models;

import java.util.Set;

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
	@JoinColumn(name = "director_id")
	private Director director;
	
	@ManyToOne
	@JoinColumn(name = "production_id")
	private Production production;

	@ManyToOne
	private Writer writer;

	@ManyToMany
	@JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private Set<Actor> actors;

	@ManyToMany
	@JoinTable(name = "movie_language", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
	private Set<Language> languages;

	@ManyToMany
	@JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private Set<Genre> genres;

	public Movie(String name, int length, Director director, Writer writer) {
		super();
		this.name = name;
		this.length = length;
		this.director = director;
	}
}
