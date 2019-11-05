package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Movie;
import com.brk.mdb.models.Production;

public interface ProductionService {

	Production insertOne(String name);

	List<Production> getByName(String name);

	List<Production> getAll();

	List<Movie> getMovies(Production p);

	List<Movie> addMovie(Production p, Movie m);

	List<Movie> removeMovie(Production p, Movie m);
}
