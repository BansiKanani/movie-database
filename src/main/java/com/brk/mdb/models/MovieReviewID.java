package com.brk.mdb.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class MovieReviewID implements Serializable {

	private static final long serialVersionUID = -8675647199740242410L;

	private Movie movie;
	private User user;

	public MovieReviewID() {}
	
	public MovieReviewID(Movie movie, User user) {
		this.movie = movie;
		this.user = user;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieReviewID other = (MovieReviewID) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

}
