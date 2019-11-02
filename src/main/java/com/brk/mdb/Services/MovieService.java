package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Movie;

public interface MovieService {
	
	void insertOne(Movie m);
	
	List<Movie> getByName(String name);
	
	List<Movie> getAll();
	
	List<Movie> getByLength(int minLength, int maxLength);
	
	List<Movie> getHasActor(Actor actor);
	
	List<Movie> getHasRatings(int min, int max);
	
	List<Movie> getDirectedBy(Director director);
	
	List<Movie> getByGenre(Genre genre);
	
	List<Movie> getByLang(Language lang);
	
	List<Movie> getWrittenBy(Writer writer);
}
