package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;

import com.brk.mdb.models.Actor;
import com.brk.mdb.models.Director;
import com.brk.mdb.models.Genre;
import com.brk.mdb.models.Language;
import com.brk.mdb.models.Movie;

public interface ActorService {

	Actor insertOne(String name, Date dob, int height, String city, String state, String country);

	List<Movie> addMovie(Actor a, Movie movie);

	List<Movie> removeMovie(Actor a, Movie movie);

	List<Movie> getMovies(Actor a);

	Actor getById(Long id);

	List<Actor> getByName(String name);

	List<Actor> getAll();

	List<Actor> getByHeight(int minLength, int maxLength);

	List<Actor> getByAge(int min, int max);

	List<Actor> getByCity(Director director);

	List<Actor> getByState(Genre genre);

	List<Actor> getByCountry(Language lang);

}
