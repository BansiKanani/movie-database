package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.modelsTO.WriterTO;

public interface WriterService {

	WriterTO insertOne(String name);

	WriterTO getById(long id);

	List<WriterTO> getByName(String name);

	List<WriterTO> getAll();
	
	List<MovieTO> getMovies(long writerId);

	List<MovieTO> addMovie(long writerId, long movieId);

	List<MovieTO> removeMovie(long writerId, long movieId);

}
