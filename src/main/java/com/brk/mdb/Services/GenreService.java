package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Genre;
import com.brk.mdb.models.Movie;

public interface GenreService {

	GenreTO insertOne(String name);

	List<MovieTO> addMovie(long genreId, long movieId);

	List<MovieTO> removeMovie(long genreId, long movieId);

	List<MovieTO> getMovies(long genreId);
	
	GenreTO getById(long id);
	
	List<GenreTO> getByName(String name);

	List<GenreTO> getAll();

}
