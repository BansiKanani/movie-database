package com.brk.mdb.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Award;
import com.brk.mdb.models.MovieAward;
import com.brk.mdb.modelsTO.AwardTO;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.repositories.AwardRepository;
import com.brk.mdb.repositories.MovieRepository;

@Service("awardService")
public class AwardServiceImpl implements AwardService {

	@Autowired
	private AwardRepository aR;

	@Autowired
	private MovieRepository mR;
	
	@Override
	public AwardTO insertOne(String name) {
		Award a = new Award(name);
		aR.save(a);
		return new AwardTO(a);
	}

	@Override
	public List<MovieTO> getMovies(long awardId) {
		List<MovieAward> movieAwards = aR.findById(awardId).orElseThrow().getMovieAwards();
		return movieAwards.stream().map(mA -> new MovieTO(mA.getMovie())).collect(Collectors.toList());		
	}

	@Override
	public AwardTO getById(long id) {	
		return new AwardTO(aR.findById(id).orElseThrow());
	}

	@Override
	public List<AwardTO> getByName(String n) {	
		return aR.findByNameLike("%"+n+"%").stream().map(a -> new AwardTO(a)).collect(Collectors.toList());
	}

	@Override
	public List<AwardTO> getAll() {
		return aR.findAll().stream().map(a -> new AwardTO(a)).collect(Collectors.toList());
	}

}
