package com.brk.mdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.Award;
import com.brk.mdb.models.Movie;
import com.brk.mdb.models.MovieAward;;

@Repository
public interface MovieAwardRepository extends JpaRepository<MovieAward, Long> {
	
	MovieAward findByMovieAndAward(Movie m, Award a);
}
