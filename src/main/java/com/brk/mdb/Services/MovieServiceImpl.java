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
import com.brk.mdb.modelsTO.ActorTO;
import com.brk.mdb.modelsTO.AwardTO;
import com.brk.mdb.modelsTO.LanguageTO;
import com.brk.mdb.modelsTO.MovieReviewTO;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.modelsTO.UserTO;
import com.brk.mdb.modelsTO.WriterTO;
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

//		return new MovieTO();
		return null;
	}

	@Override
	public List<MovieTO> getAll() {
		return mR.findAll().stream().map(m -> new MovieTO(m)).collect(Collectors.toList());
	}

	@Override
	public MovieTO getById(long movieId) {
		return new MovieTO(mR.findById(movieId).orElseThrow());
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
		return mR.findByNameLike("%" + name + "%").stream().map(m -> new MovieTO(m)).collect(Collectors.toList());
	}

	@Override
	public List<AwardTO> getAwards(long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTO> getWishListedBy(long movieId) {
		return mR.findById(movieId).orElseThrow().getWishlistedBy().stream().map(u -> new UserTO(u))
				.collect(Collectors.toList());
	}

	@Override
	public List<MovieReviewTO> getReviews(long movieId) {
		return mR.findById(movieId).orElseThrow().getMovieReview().stream().map(mr -> new MovieReviewTO(mr))
				.collect(Collectors.toList());
	}

	@Override
	public List<ActorTO> getActors(long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LanguageTO> getLang(long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WriterTO> getWriters(long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
