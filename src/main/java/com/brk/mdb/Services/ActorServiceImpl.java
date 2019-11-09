package com.brk.mdb.Services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
	private ActorRepository actorRepo;

	@Override
	public ActorTO insertOne(String name, Date dob, int height, String city, String state, String country) {
		Actor a = new Actor(name, height, city, state, country, dob, new ArrayList<Movie>());
		actorRepo.save(a);
		return new ActorTO(a);
	}

	@Override
	public List<MovieTO> getMovies(long actorId) {
		return actorRepo.findById(actorId).orElseThrow().getMovies().stream().map(m -> new MovieTO(m))
				.collect(Collectors.toList());
	}

	@Override
	public ActorTO getById(long actorId) {
		return new ActorTO(actorRepo.findById(actorId).orElseThrow());
	}

	@Override
	public List<ActorTO> getByName(String name) {
		return actorRepo.findByNameLike("%" + name + "%").stream().map(a -> new ActorTO(a))
				.collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getAll() {
		return actorRepo.findAll().stream().map(a -> new ActorTO(a)).collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getByHeight(int min, int max) {
		return actorRepo.findByHeightGreaterThanEqualAndHeightLessThanEqual(min, max).stream().map(a -> new ActorTO(a))
				.collect(Collectors.toList());
	}

	public Date getDobFromAge(int age) {
		LocalDate today = LocalDate.now();
		try {
			return new SimpleDateFormat("yyyy/MM/dd")
					.parse((today.getYear() - age) + "/" + today.getMonthValue() + "/" + today.getDayOfMonth());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Date();
	}

	@Override
	public List<ActorTO> getByAge(int minAge, int maxAge) {
		return actorRepo.findByDobBetween(getDobFromAge(maxAge), getDobFromAge(minAge)).stream()
				.map(a -> new ActorTO(a)).collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getByCity(String city) {
		return actorRepo.findByCityLike("%" + city + "%").stream().map(a -> new ActorTO(a))
				.collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getByState(String state) {
		return actorRepo.findByStateLike("%" + state + "%").stream().map(a -> new ActorTO(a))
				.collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getByCountry(String country) {
		return actorRepo.findByCountryLike("%" + country + "%").stream().map(a -> new ActorTO(a))
				.collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getByPlace(String country, String state, String city) {
		return actorRepo
				.findByCountryLikeAndStateLikeAndCityLike("%" + country + "%", "%" + state + "%", "%" + city + "%")
				.stream().map(a -> new ActorTO(a)).collect(Collectors.toList());
	}

}
