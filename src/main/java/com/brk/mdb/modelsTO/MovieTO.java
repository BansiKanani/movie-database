package com.brk.mdb.modelsTO;

import java.util.Date;

import com.brk.mdb.models.Movie;

import lombok.Data;

@Data
public class MovieTO {

	private long id;
	private String name;
	private int runTime;
	private long budget;
	private long boxOffice;
	private String story;
	private String censorRating;
	private Date releaseDate;

	public MovieTO(Movie m) {

		this.name = m.getName();
		this.runTime = m.getRunTime();
		this.budget = m.getBudget();
		this.boxOffice = m.getBoxOffice();
		this.story = m.getStory();
		this.censorRating = m.getCensorRating();
		this.releaseDate = m.getReleaseDate();

	}

}
