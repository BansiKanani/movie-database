package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.modelsTO.AwardTO;
import com.brk.mdb.modelsTO.MovieTO;

public interface AwardService {

	AwardTO insertOne(String name);

	List<MovieTO> getMovies(long awardId);
	
	AwardTO getById(long awardId);

	List<AwardTO> getByName(String name);

	List<AwardTO> getAll();

}
