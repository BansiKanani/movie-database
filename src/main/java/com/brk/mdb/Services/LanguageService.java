package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Language;
import com.brk.mdb.models.Movie;

public interface LanguageService {
	
	Language insertOne(String name);

	List<Movie> addMovie(Language l, Movie m);

	List<Movie> removeMovie(Language l, Movie m);

	List<Movie> getMovies(Language l);
	
	Language getById(Long id);
	
	List<Language> getByName(String name);

	List<Language> getAll();
}
