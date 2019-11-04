package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Director;
import com.brk.mdb.models.Movie;

public interface DirectorService {

	Director insertOne(String name);

	List<Movie> addMovie(Director d, Movie m);

	List<Movie> removeMovie(Director d, Movie m);

	List<Movie> getMovies(Director d);

	Director getById(Long id);

	List<Director> getByName(String n);

	List<Director> getAll();

}
