package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Genre;
import com.brk.mdb.models.Movie;

public interface GenreService {

	Genre insertOne(String name);

	List<Movie> addMovie(Genre g, Movie m);

	List<Movie> removeMovie(Genre g, Movie m);

	List<Movie> getMovies(Genre g);
	
	Genre getById(Long id);
	
	List<Genre> getByName(String name);

	List<Genre> getAll();

}
