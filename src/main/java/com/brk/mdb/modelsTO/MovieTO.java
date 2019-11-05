package com.brk.mdb.modelsto;

import java.util.Date;
import java.util.Set;

public class MovieTO {

	private long id;

	private String name;

	private int runTime;

	private long boxOffice;
	private long budget;

	private String censorRating;
	private String story;

	private Date releaseDate;

	private DirectorTO director;

	private ProductionTO production;

	private Set<WriterTO> writers;

	private Set<ActorTO> actors;

	private Set<LanguageTO> languages;

	private Set<GenreTO> genres;

	private Set<MovieAwardTO> movieAwards;

	private Set<MovieReviewTO> movieReview;

	private Set<UserTO> wishlistedBy;

	public MovieTO(String name, int runTime, long boxOffice, long budget, String censorRating, String story,
			Date releaseDate, DirectorTO director, ProductionTO production, Set<WriterTO> writers, Set<ActorTO> actors,
			Set<LanguageTO> languages, Set<GenreTO> genres, Set<MovieAwardTO> movieAwards,
			Set<MovieReviewTO> movieReview, Set<UserTO> wishlistedBy) {
		super();
		this.name = name;
		this.runTime = runTime;
		this.boxOffice = boxOffice;
		this.budget = budget;
		this.censorRating = censorRating;
		this.story = story;
		this.releaseDate = releaseDate;
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
		return "Movie [id=" + id + ", name=" + name + ", runTime=" + runTime + ", boxOffice=" + boxOffice + ", budget="
				+ budget + ", censorRating=" + censorRating + ", story=" + story + ", releaseDate=" + releaseDate
				+ ", director=" + director + ", production=" + production + ", writers=" + writers + ", actors="
				+ actors + ", languages=" + languages + ", genres=" + genres + ", movieAwards=" + movieAwards
				+ ", movieReview=" + movieReview + ", wishlistedBy=" + wishlistedBy + "]";
	}

}
