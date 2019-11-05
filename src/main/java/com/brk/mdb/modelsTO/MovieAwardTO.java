package com.brk.mdb.modelsto;

import java.util.Date;

public class MovieAwardTO {

	private MovieTO movie;

	private AwardTO award;

	private Date date;

	public MovieAwardTO(MovieTO movie, AwardTO award, Date date) {
		super();
		this.movie = movie;
		this.award = award;
		this.date = date;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieAwardTO other = (MovieAwardTO) obj;
		if (award == null) {
			if (other.award != null)
				return false;
		} else if (!award.equals(other.award))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		return result;
	}
}