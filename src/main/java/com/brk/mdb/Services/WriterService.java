package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Movie;
import com.brk.mdb.models.Writer;

public interface WriterService {

	Writer insertOne(String name);

	Writer getById(long id);

	List<Writer> getByName(String name);

	List<Writer> getAll();
	
	List<Movie> getMovies(Writer w);

	List<Movie> addMovie(Writer w, Movie m);

	List<Movie> removeMovie(Writer w, Movie m);

}
