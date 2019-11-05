package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.brk.mdb.models.Actor;
import com.brk.mdb.models.Award;
import com.brk.mdb.models.Director;
import com.brk.mdb.models.Genre;
import com.brk.mdb.models.Language;
import com.brk.mdb.models.Movie;
import com.brk.mdb.models.Production;
import com.brk.mdb.models.User;
import com.brk.mdb.models.Writer;

public interface MovieService {

	Movie insertOne(String name, int runTime, long budget, long boxOffice, String censorRating, String story,
			Date releaseDate, Set<Genre> genres, Director director, Production production, Set<Writer> writers,
			Set<Actor> actors, Set<Language> languages);

	Movie updateBoxOffice(Movie m, long newIncome);
	
	List<Movie> getByName(String name);

	List<Movie> getAll();

	Optional<Movie> getById(long id);
	
	List<Movie> getByRunTime(int minLength, int maxLength);

	List<Movie> addAward(Movie m, Award a, Date d);

	List<Movie> removeAward(Movie m, Date d);

	List<Movie> addWhiteListedBy(Movie m, User u);
	
	List<Movie> removeWhiteListedBy(Movie m, User u);
	
	List<Movie> addReview(Movie m, User u, int rating, String comment);

	List<Movie> removeReview(Movie m, User u);
	
	List<Movie> getByDate(Date earliest, Date latest);
	
	List<Movie> getByCensorRating(String censorRating);
	
	List<Movie> getByBudget(long min, long max);
	
	List<Movie> getByBoxOffice(long min, long max);
	
	
}
