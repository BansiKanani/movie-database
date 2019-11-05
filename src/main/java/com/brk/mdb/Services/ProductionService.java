package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Movie;
import com.brk.mdb.models.Production;

public interface ProductionService {

	ProductionTO insertOne(String name);

	List<ProductionTO> getByName(String name);

	List<ProductionTO> getAll();

	List<Movie> getMovies(long productionId);

	List<Movie> addMovie(long productionId, long movieId);

	List<Movie> removeMovie(long productionId, long movieId);
}
