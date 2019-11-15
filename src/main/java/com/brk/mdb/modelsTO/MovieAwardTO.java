package com.brk.mdb.modelsTO;

import java.util.Date;

import com.brk.mdb.models.MovieAward;

import lombok.Data;

@Data
public class MovieAwardTO {

	private MovieTO movie;
	private AwardTO award;
	private Date date;

	public MovieAwardTO(MovieAward ma) {
		this.movie = new MovieTO(ma.getMovie());
		this.award = new AwardTO(ma.getAward());
		this.date = ma.getDate();
	}

	public MovieAwardTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}