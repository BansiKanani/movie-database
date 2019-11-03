package com.brk.mdb.models;

import java.util.Date;
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

	private long boxOffice;
	private long budget;

	private String censorRating;
	private String story;

	@Temporal(TemporalType.DATE)
	private Date releaseDate;

	@Temporal(TemporalType.TIME)
	private Date runTime;

	@ManyToOne
	@JoinColumn(name = "director_id")
	private Director director;

	@ManyToOne
	@JoinColumn(name = "production_id")
	private Production production;

	@ManyToMany
	@JoinTable(name = "movie_writer", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "writer_id"))
	private Set<Actor> writers;

	@ManyToMany
	@JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private Set<Actor> actors;

	@ManyToMany
	@JoinTable(name = "movie_language", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
	private Set<Language> languages;

	@ManyToMany
	@JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private Set<Genre> genres;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<MovieAward> movieAwards;
	
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<MovieReview> movieReview;
    
    @ManyToMany(mappedBy = "wishlist")
    private Set<User> wishlistedBy;

	public Movie(String name, int length, long boxOffice, long budget, String censorRating, String story,
			Date releaseDate, Date runTime, Director director, Production production, Set<Actor> writers,
			Set<Actor> actors, Set<Language> languages, Set<Genre> genres, Set<MovieAward> movieAwards,
			Set<MovieReview> movieReview, Set<User> wishlistedBy) {
		super();
		this.name = name;
		this.length = length;
		this.boxOffice = boxOffice;
		this.budget = budget;
		this.censorRating = censorRating;
		this.story = story;
		this.releaseDate = releaseDate;
		this.runTime = runTime;
		this.director = director;
		this.production = production;
		this.writers = writers;
		this.actors = actors;
		this.languages = languages;
		this.genres = genres;
		this.movieAwards = movieAwards;
		this.movieReview = movieReview;
		this.wishlistedBy = wishlistedBy;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", length=" + length + ", boxOffice=" + boxOffice + ", budget="
				+ budget + ", censorRating=" + censorRating + ", story=" + story + ", releaseDate=" + releaseDate
				+ ", runTime=" + runTime + ", director=" + director + ", production=" + production + ", writers="
				+ writers + ", actors=" + actors + ", languages=" + languages + ", genres=" + genres + ", movieAwards="
				+ movieAwards + ", movieReview=" + movieReview + ", wishlistedBy=" + wishlistedBy + "]";
	}
    
    
}
