package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Actor;
import com.brk.mdb.models.Director;
import com.brk.mdb.models.Genre;
import com.brk.mdb.models.Language;
import com.brk.mdb.models.Movie;
import com.brk.mdb.models.Writer;

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
