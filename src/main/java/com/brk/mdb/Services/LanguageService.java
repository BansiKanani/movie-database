package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.modelsTO.LanguageTO;
import com.brk.mdb.modelsTO.MovieTO;

public interface LanguageService {
	
	LanguageTO insertOne(String name);

	List<MovieTO> getMovies(long langId);
	
	LanguageTO getById(long id);
	
	List<LanguageTO> getByName(String name);

	List<LanguageTO> getAll();
}
