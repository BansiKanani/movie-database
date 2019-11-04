package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;

import com.brk.mdb.models.Award;
import com.brk.mdb.models.Movie;

public interface AwardService {

	Award insertOne(String name);

	List<Movie> addMovie(Award a, Movie m, Date d);

	List<Movie> removeMovie(Award a, Movie m);

	List<Movie> getMovies(Award a);
	
	Award getById(Long id);

	List<Award> getByName(String n);

	List<Award> getAll();

}
