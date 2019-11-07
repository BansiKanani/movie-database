package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Movie;
import com.brk.mdb.modelsTO.ActorTO;
import com.brk.mdb.modelsTO.DirectorTO;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.repositories.ActorRepository;

@Service("actorService")
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository aR;

	@Override
	public ActorTO insertOne(String name, Date dob, int height, String city, String state, String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieTO> getMovies(long actorId) {
		List<Movie> movies = aR.findById(actorId).orElseThrow().getMovies();
		return movies.stream().map(m -> new MovieTO(m)).collect(Collectors.toList());
	}

	@Override
	public ActorTO getById(long actorid) {
		return new ActorTO(aR.findById(actorid).orElseThrow());
	}

	@Override
	public List<ActorTO> getByName(String name) {
		return aR.findByNameLike("%" + name + "%").stream().map(a -> new ActorTO(a)).collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getAll() {
		return aR.findAll().stream().map(a -> new ActorTO(a)).collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getByHeight(int min, int max) {
		return aR.findByHeightGreaterThanEqualAndHeightLessThanEqual(min, max).stream().map(a -> new ActorTO(a))
				.collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getByAge(int min, int max) {
		
//		Date s = new Date();
//		
//		return aR.findByDobBetween(start, end).stream().map(a -> new ActorTO(a))
//				.collect(Collectors.toList());
		return null;
	}

	@Override
	public List<ActorTO> getByCity(long directorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActorTO> getByState(long genreId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActorTO> getByCountry(long langId) {
		// TODO Auto-generated method stub
		return null;
	}

}
