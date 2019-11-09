package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;

import com.brk.mdb.modelsTO.ActorTO;
import com.brk.mdb.modelsTO.AwardTO;
import com.brk.mdb.modelsTO.DirectorTO;
import com.brk.mdb.modelsTO.GenreTO;
import com.brk.mdb.modelsTO.LanguageTO;
import com.brk.mdb.modelsTO.MovieReviewTO;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.modelsTO.ProductionTO;
import com.brk.mdb.modelsTO.UserTO;
import com.brk.mdb.modelsTO.WriterTO;

public interface MovieService {

	MovieTO insertOne(String name, int runTime, long budget, long boxOffice, String censorRating, String story,
			Date releaseDate);

	List<MovieTO> getAll();

	MovieTO getById(long movieId);

	List<MovieTO> getByName(String name);

	List<MovieTO> getByRunTime(int minLength, int maxLength);

	// awards
	List<AwardTO> getAwards(long movieId);

	boolean addAward(long movieId, long awardId, Date d);

	boolean removeAward(long movieId, long awardId);

	// wish list
	List<UserTO> getWishListedBy(long movieId);

	// reviews
	List<MovieReviewTO> getReviews(long movieId);

	boolean addReview(long movieId, long userId, int rating, String comment);

	boolean removeReview(long movieId, long userId);

	List<MovieTO> getByDate(Date earliest, Date latest);

	List<MovieTO> getByCensorRating(String censorRating);

	List<MovieTO> getByBudget(long min, long max);

	List<MovieTO> getByBoxOffice(long min, long max);

	boolean updateBoxOffice(long movieId, long newIncome);

	// actors
	List<ActorTO> getActors(long movieId);

	boolean addActor(long movieId, long actorId);

	boolean removeActor(long movieId, long actorId);

	// languages
	List<LanguageTO> getLanguages(long movieId);

	boolean addLanguage(long movieId, long langId);

	boolean removeLanguage(long movieId, long langId);
	
	// genres
	List<GenreTO> getGenres(long movieId);

	boolean addGenre(long movieId, long genreId);

	boolean removeGenre(long movieId, long genreId);

	// writers
	List<WriterTO> getWriters(long movieId);

	boolean addWriter(long movieId, long writerId);

	boolean removeWriter(long movieId, long writerId);

	// director
	DirectorTO getDirector(long movieId);

	boolean setDirector(long movieId, long directorId);

	// production
	ProductionTO getProduction(long movieId);

	boolean setProduction(long movieId, long productionId);

}
