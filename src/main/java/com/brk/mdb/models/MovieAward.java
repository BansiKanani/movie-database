package com.brk.mdb.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@IdClass(MovieAwardID.class)
public class MovieAward {

	@Id
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_id")
	private Movie movie;

	@Id
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "award_id")
	private Award award;

	@Temporal(TemporalType.DATE)
	private Date date;

	public MovieAward(Movie movie, Award award, Date date) {
		this.movie = movie;
		this.award = award;
		this.date = date;
	}

	public MovieAward() {
		super();
		// TODO Auto-generated constructor stub
	}
}