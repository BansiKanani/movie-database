package com.brk.mdb.modelsTO;

import com.brk.mdb.models.MovieReview;

import lombok.Data;

@Data
public class MovieReviewTO {

	private MovieTO movie;
	private UserTO user;
	private int rating;
	private String comment;

	public MovieReviewTO(MovieReview mR) {
		this.movie = new MovieTO(mR.getMovie());
		this.user = new UserTO(mR.getUser());
		this.rating = mR.getRating();
		this.comment = mR.getComment();
	}

	@Override
	public String toString() {
		return "MovieReviewTO [movie=(" + movie.getId() + ")" + movie.getName() + ", user=" + user.getId() + ")"
				+ user.getFname() + ", rating=" + rating + ", comment=" + comment + "]";
	}
}
