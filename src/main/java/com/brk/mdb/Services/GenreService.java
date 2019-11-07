package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.modelsTO.GenreTO;
import com.brk.mdb.modelsTO.MovieTO;

public interface GenreService {

	GenreTO insertOne(String name);

	List<MovieTO> getMovies(long genreId);
	
	GenreTO getById(long id);
	
	List<GenreTO> getByName(String name);

	List<GenreTO> getAll();

}
