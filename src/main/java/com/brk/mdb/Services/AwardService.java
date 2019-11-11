package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.modelsTO.AwardTO;
import com.brk.mdb.modelsTO.MovieAwardTO;

public interface AwardService {

	AwardTO insertOne(String name);

	List<MovieAwardTO> getMovieAwards(long awardId);
	
	AwardTO getById(long awardId);

	List<AwardTO> getByName(String name);

	List<AwardTO> getAll();

}