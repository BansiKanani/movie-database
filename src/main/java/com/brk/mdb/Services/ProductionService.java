package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.modelsTO.ProductionTO;

public interface ProductionService {

	ProductionTO insertOne(String name);

	ProductionTO getById(long productionId);
	
	List<ProductionTO> getByName(String name);

	List<ProductionTO> getAll();

	List<MovieTO> getMovies(long productionId);

}
