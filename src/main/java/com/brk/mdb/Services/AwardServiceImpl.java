package com.brk.mdb.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Award;
import com.brk.mdb.modelsTO.AwardTO;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.repositories.AwardRepository;

@Service("awardService")
public class AwardServiceImpl implements AwardService {

	@Autowired
	private AwardRepository awardRepo;

	@Override
	public AwardTO insertOne(String name) {
		Award a = new Award(name);
		awardRepo.save(a);
		return new AwardTO(a);
	}

	@Override
	public List<MovieTO> getMovies(long awardId) {
		return awardRepo.findById(awardId).orElseThrow().getMovieAwards().stream().map(mA -> new MovieTO(mA.getMovie()))
				.collect(Collectors.toList());
	}

	@Override
	public AwardTO getById(long awardId) {
		return new AwardTO(awardRepo.findById(awardId).orElseThrow());
	}

	@Override
	public List<AwardTO> getByName(String name) {
		return awardRepo.findByNameLike("%" + name + "%").stream().map(a -> new AwardTO(a)).collect(Collectors.toList());
	}

	@Override
	public List<AwardTO> getAll() {
		return awardRepo.findAll().stream().map(a -> new AwardTO(a)).collect(Collectors.toList());
	}

}
