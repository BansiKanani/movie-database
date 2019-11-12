package com.brk.mdb.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class MovieAwardID implements Serializable {

	private static final long serialVersionUID = 5924628547718880805L;

	private Movie movie;
	private Award award;

	public MovieAwardID() {
		super();
	}

	public MovieAwardID(Movie movie, Award award) {
		this.movie = movie;
		this.award = award;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieAwardID other = (MovieAwardID) obj;
		if (award == null) {
			if (other.award != null)
				return false;
		} else if (!award.equals(other.award))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((award == null) ? 0 : award.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		return result;
	}

}