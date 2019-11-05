package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Language;
import com.brk.mdb.models.Movie;

public interface LanguageService {
	
	LanguageTO insertOne(String name);

	List<MovieTO> addMovie(long langId, long movieId);

	List<MovieTO> removeMovie(long langId, long movieId);

	List<MovieTO> getMovies(long langId);
	
	LanguageTO getById(long id);
	
	List<LanguageTO> getByName(String name);

	List<LanguageTO> getAll();
}
