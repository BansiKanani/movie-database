package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;

import com.brk.mdb.models.Actor;
import com.brk.mdb.models.Director;
import com.brk.mdb.models.Genre;
import com.brk.mdb.models.Language;
import com.brk.mdb.models.Movie;

public interface ActorService {

	ActorTO insertOne(String name, Date dob, int height, String city, String state, String country);

	List<MovieTO> addMovie(long actorId, long movieId);

	List<MovieTO> removeMovie(long actorId, long movieId);

	List<MovieTO> getMovies(long actorId);

	ActorTO getById(long actorid);

	List<ActorTO> getByName(String name);

	List<ActorTO> getAll();

	List<ActorTO> getByHeight(int minLength, int maxLength);

	List<ActorTO> getByAge(int min, int max);

	List<ActorTO> getByCity(long directorId);

	List<ActorTO> getByState(long genreId);

	List<ActorTO> getByCountry(long langId);

}
