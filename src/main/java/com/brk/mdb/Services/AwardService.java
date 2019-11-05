package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;

import com.brk.mdb.models.Award;
import com.brk.mdb.models.Movie;

public interface AwardService {

	AwardTO insertOne(String name);

	List<MovieTO> addMovie(long awardId, long movieId, Date d);

	List<MovieTO> removeMovie(long awardId, long movieId);

	List<MovieTO> getMovies(long awardId);
	
	AwardTO getById(long id);

	List<AwardTO> getByName(String n);

	List<AwardTO> getAll();

}
