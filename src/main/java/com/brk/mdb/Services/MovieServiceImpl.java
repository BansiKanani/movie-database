package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Actor;
import com.brk.mdb.models.Award;
import com.brk.mdb.models.Director;
import com.brk.mdb.models.Genre;
import com.brk.mdb.models.Language;
import com.brk.mdb.models.Movie;
import com.brk.mdb.models.Production;
import com.brk.mdb.models.User;
import com.brk.mdb.models.Writer;
import com.brk.mdb.repositories.MovieRepository;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	

	public List<Movie> getByName(String name) {
		return movieRepository.findByNameLike("%"+name+"%");
	}


	@Override
	public Movie insertOne(String name, int runTime, long budget, long boxOffice, String censorRating, String story,
			Date releaseDate, Set<Genre> genres, Director director, Production production, Set<Writer> writers,
			Set<Actor> actors, Set<Language> languages) {
		
		Movie m = new Movie(name, runTime, boxOffice, budget, censorRating, story, releaseDate, director, production, writers, actors, languages, genres, movieReview, wishlistedBy);

		movieRepository.save(m);
		return null;
	}


	@Override
	public Movie updateBoxOffice(Movie m, long newIncome) {
		Movie mm = movieRepository.findById(m.getId()).orElseThrow();
		mm.setBoxOffice(newIncome);
		return mm;
	}


	@Override
	public List<Movie> getAll() {
		movieRepository.findAll();
		return null;
	}


	@Override
	public Optional<Movie> getById(long id) {
		movieRepository.findById(id).orElseThrow()
	}


	@Override
	public List<Movie> getByRunTime(int minLength, int maxLength) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> addAward(Movie m, Award a, Date d) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> removeAward(Movie m, Date d) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> addWhiteListedBy(Movie m, User u) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> removeWhiteListedBy(Movie m, User u) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> addReview(Movie m, User u, int rating, String comment) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> removeReview(Movie m, User u) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> getByDate(Date earliest, Date latest) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> getByCensorRating(String censorRating) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> getByBudget(long min, long max) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> getByBoxOffice(long min, long max) {
		// TODO Auto-generated method stub
		return null;
	}


}
