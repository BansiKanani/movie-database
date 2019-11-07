package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Movie;
import com.brk.mdb.modelsTO.ProductionTO;

public interface ProductionService {

	ProductionTO insertOne(String name);

	List<ProductionTO> getByName(String name);

	List<ProductionTO> getAll();

	List<Movie> getMovies(long productionId);

}
