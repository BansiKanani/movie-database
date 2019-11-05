package com.brk.mdb.modelsto;

public class MovieReviewTO {

	private MovieTO movie;

	private UserTO user;

	private int rating;
	private String comment;

	public MovieReviewTO(MovieTO movie, UserTO user, int rating, String comment) {
		super();
		this.movie = movie;
		this.user = user;
		this.rating = rating;
		this.comment = comment;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieReviewTO other = (MovieReviewTO) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (rating != other.rating)
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
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + rating;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
}
