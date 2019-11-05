package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Director;
import com.brk.mdb.models.Movie;

public interface DirectorService {

	DirectorTO insertOne(String name);

	List<MovieTO> addMovie(long directorId, long movieId);

	List<MovieTO> removeMovie(long directorId, long movieId);

	List<MovieTO> getMovies(long directorId);

	DirectorTO getById(long id);

	List<DirectorTO> getByName(String n);

	List<DirectorTO> getAll();

}
