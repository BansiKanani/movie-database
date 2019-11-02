package com.brk.mdb.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Movie;
import com.brk.mdb.repositories.MovieRepository;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public void insertOne(Movie movie) {
		movieRepository.save(movie);
	}

	public List<Movie> getAll() {
		return movieRepository.findAll();
	}

	public List<Movie> getShorterThan(int length) {
		return movieRepository.findByLengthLessThanEqual(length);
	}

	public List<Movie> getLongerThan(int length) {
		return movieRepository.findByLengthGreaterThanEqual(length);
	}

	public List<Movie> getLengthInBetween(int minLength, int maxLength) {
		return movieRepository.findByLengthGreaterThanEqualAndLengthLessThanEqual(minLength, maxLength);
	}

	public List<Movie> getByName(String name) {
		return movieRepository.findByNameLike("%"+name+"%");
	}


}
