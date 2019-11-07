package com.brk.mdb.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Award;
import com.brk.mdb.models.Movie;
import com.brk.mdb.models.MovieAward;
import com.brk.mdb.modelsTO.AwardTO;
import com.brk.mdb.modelsTO.MovieReviewTO;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.modelsTO.UserTO;
import com.brk.mdb.repositories.AwardRepository;
import com.brk.mdb.repositories.MovieRepository;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository mR;
	
	@Autowired
	private AwardRepository aR;
	

	@Override
	public MovieTO insertOne(String name, int runTime, long budget, long boxOffice, String censorRating, String story,
			Date releaseDate, long directorId, long productionId, Set<Long> writersId, Set<Long> actorsId,
			Set<Long> languages, Set<Long> genres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieTO getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieTO> getByRunTime(int minLength, int maxLength) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AwardTO> addAward(long movieId, long awardId, Date d) {
		
		Movie m = mR.findById(movieId).orElseThrow();
		Award a = aR.findById(awardId).orElseThrow();
		
		List<MovieAward> mas = a.getMovieAwards();
		
		mas.add(new MovieAward(m, a, d));
		a.setMovieAwards(mas);
		m.setMovieAwards(mas);
		
//      -----old-----------		
//		MovieAward ma = new MovieAward(m, a, d);
//		a.getMovieAwards().add(ma);
//		m.getMovieAwards().add(ma);
		
		aR.flush();
		mR.flush();
		
		return getAwards(movieId, awardId);
	}

	@Override
	public List<AwardTO> removeAward(long movieId, long awardId) {
		
		Movie m = mR.findById(movieId).orElseThrow();
		Award a = aR.findById(awardId).orElseThrow();
		List<MovieAward> mas = new ArrayList<>();
		
		mas = a.getMovieAwards().stream().filter(ma -> ma.getMovie().getId() != movieId).collect(Collectors.toList());
		a.setMovieAwards(mas);
		m.setMovieAwards(mas);
		
//		------old code-----------
//		for (MovieAward ma : a.getMovieAwards()) {
//			if (ma.getMovie().getId() == movieId) {
//				a.getMovieAwards().remove(ma);
//				m.getMovieAwards().remove(ma);				
//			}
//		}
		aR.flush();
		mR.flush();
		
		return getAwards(movieId, awardId);
	}

	@Override
	public List<UserTO> addWhiteListedBy(long movieId, long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTO> removeWhiteListedBy(long movieId, long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieReviewTO> addReview(long movieId, long userId, int rating, String comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieReviewTO> removeReview(long movieId, long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieTO> getByDate(Date earliest, Date latest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieTO> getByCensorRating(String censorRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieTO> getByBudget(long min, long max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieTO> getByBoxOffice(long min, long max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieTO updateBoxOffice(long movieId, long newIncome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieTO addActor(long movieId, long actorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieTO removeActor(long movieId, long actorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieTO addLang(long movieId, long langId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieTO removeLang(long movieId, long langId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieTO addWriter(long movieId, long writerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieTO removeWriter(long movieId, long writerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieTO> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AwardTO> getAwards(long movieId, long awardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AwardTO> getWhiteListedBy(long movieId, long awardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AwardTO> getReviews(long movieId, long awardId) {
		// TODO Auto-generated method stub
		return null;
	}


}
