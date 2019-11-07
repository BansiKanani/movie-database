package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.modelsTO.DirectorTO;
import com.brk.mdb.modelsTO.MovieTO;

public interface DirectorService {

	DirectorTO insertOne(String name);

	List<MovieTO> getMovies(long directorId);

	DirectorTO getById(long directorId);

	List<DirectorTO> getByName(String name);

	List<DirectorTO> getAll();

}
