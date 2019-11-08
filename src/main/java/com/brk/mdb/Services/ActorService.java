package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;

import com.brk.mdb.modelsTO.ActorTO;
import com.brk.mdb.modelsTO.MovieTO;

public interface ActorService {

	ActorTO insertOne(String name, Date dob, int height, String city, String state, String country);

	List<MovieTO> getMovies(long actorId);

	ActorTO getById(long actorId);

	List<ActorTO> getByName(String name);

	List<ActorTO> getAll();

	List<ActorTO> getByHeight(int min, int max);

	List<ActorTO> getByAge(int min, int max);

	List<ActorTO> getByCity(String city);

	List<ActorTO> getByState(String state);

	List<ActorTO> getByCountry(String country);
	
	List<ActorTO> getByPlace(String country, String state, String city);

}
