package com.brk.mdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.Movie;
import com.brk.mdb.models.MovieReview;
import com.brk.mdb.models.User;;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {

	MovieReview findByMovieAndUser(Movie m, User u);
	
}
