package com.brk.mdb.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;

	private int runTime;

	private long budget;
	private long boxOffice;

	private String censorRating;
	private String story;

	@Temporal(TemporalType.DATE)
	private Date releaseDate;

	@ManyToOne
	@JoinColumn(name = "director_id")
	private Director director;

	@ManyToOne
	@JoinColumn(name = "production_id")
	private Production production;

	@ManyToMany
	@JoinTable(name = "movie_writer", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "writer_id"))
	private List<Writer> writers;

	@ManyToMany
	@JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private List<Actor> actors;

	@ManyToMany
	@JoinTable(name = "movie_language", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
	private List<Language> languages;

	@ManyToMany
	@JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre> genres;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<MovieAward> movieAwards;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<MovieReview> movieReview;

	@ManyToMany(mappedBy = "wishlist")
	private List<User> wishlistedBy;

	public Movie(String name, int runTime, long budget, long boxOffice, String censorRating, String story,
			Date releaseDate) {
		super();
		this.name = name;
		this.runTime = runTime;
		this.budget = budget;
		this.boxOffice = boxOffice;
		this.censorRating = censorRating;
		this.story = story;
		this.releaseDate = releaseDate;
		this.director = null;
		this.production = null;
		this.writers = new ArrayList<Writer>();
		this.actors = new ArrayList<Actor>();
		this.languages = new ArrayList<Language>();
		this.genres = new ArrayList<Genre>();
		this.movieAwards = new ArrayList<MovieAward>();
		this.movieReview = new ArrayList<MovieReview>();
		this.wishlistedBy = new ArrayList<User>();
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", runTime=" + runTime + ", budget=" + budget + ", boxOffice="
				+ boxOffice + ", censorRating=" + censorRating + ", story=" + story + ", releaseDate=" + releaseDate
				+ ", director=" + director + ", production=" + production + ", writers=" + writers + ", actors="
				+ actors + ", languages=" + languages + ", genres=" + genres + ", movieAwards=" + movieAwards
				+ ", movieReview=" + movieReview + ", wishlistedBy=" + wishlistedBy + "]";
	}

}
