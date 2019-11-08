package com.brk.mdb.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Actor;
import com.brk.mdb.models.Movie;
import com.brk.mdb.modelsTO.ActorTO;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.repositories.ActorRepository;

@Service("actorService")
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository aR;

	@Override
	public ActorTO insertOne(String name, Date dob, int height, String city, String state, String country) {
		Actor a = new Actor(name, height, city, state, country, dob, new ArrayList<Movie>());
		aR.saveAndFlush(a);
		return new ActorTO(a);
	}

	@Override
	public List<MovieTO> getMovies(long actorId) {
		return aR.findById(actorId).orElseThrow().getMovies().stream().map(m -> new MovieTO(m))
				.collect(Collectors.toList());
	}

	@Override
	public ActorTO getById(long actorId) {
		return new ActorTO(aR.findById(actorId).orElseThrow());
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
	public List<ActorTO> getByAge(int minAge, int maxAge) {

//		Date Today = new Date();
//		
//		Date minBirthDate = Today - new Date();
//		Date maxBirthDate = new Date();
//		

//		return aR.findByDobBetween(start, end).stream().map(a -> new ActorTO(a))
//				.collect(Collectors.toList());
		return null;
	}

	@Override
	public List<ActorTO> getByCity(String city) {
		return aR.findByCityLike("%" + city + "%").stream().map(a -> new ActorTO(a)).collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getByState(String state) {
		return aR.findByStateLike("%" + state + "%").stream().map(a -> new ActorTO(a)).collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getByCountry(String country) {
		return aR.findByCountryLike("%" + country + "%").stream().map(a -> new ActorTO(a)).collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getByPlace(String country, String state, String city) {
		return aR.findByCountryLikeAndStateLikeAndCityLike("%" + country + "%", "%" + state + "%", "%" + city + "%")
				.stream().map(a -> new ActorTO(a)).collect(Collectors.toList());
	}

}
