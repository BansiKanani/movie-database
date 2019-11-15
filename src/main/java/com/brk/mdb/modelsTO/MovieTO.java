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
		this.id = m.getId();
		this.name = m.getName();
		this.runTime = m.getRunTime();
		this.budget = m.getBudget();
		this.boxOffice = m.getBoxOffice();
		this.story = m.getStory();
		this.censorRating = m.getCensorRating();
		this.releaseDate = m.getReleaseDate();

	}

	public MovieTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MovieTO [id=" + id + ", name=" + name + ", runTime=" + runTime + ", budget=" + budget + ", boxOffice="
				+ boxOffice + ", story=" + story + ", censorRating=" + censorRating + ", releaseDate=" + releaseDate
				+ "]";
	}

	
}
