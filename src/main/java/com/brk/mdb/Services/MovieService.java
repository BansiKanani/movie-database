package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.brk.mdb.modelsTO.AwardTO;
import com.brk.mdb.modelsTO.MovieReviewTO;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.modelsTO.UserTO;

public interface MovieService {

	MovieTO insertOne(String name, int runTime, long budget, long boxOffice, String censorRating, String story,
			Date releaseDate, long directorId, long productionId, Set<Long> writersId, Set<Long> actorsId,
			Set<Long> languages, Set<Long> genres);

	List<MovieTO> getAll();

	MovieTO getById(long id);

	List<MovieTO> getByName(String name);

	List<MovieTO> getByRunTime(int minLength, int maxLength);

	// awards
	List<AwardTO> getAwards(long movieId, long awardId);
	
	List<AwardTO> addAward(long movieId, long awardId, Date d);

	List<AwardTO> removeAward(long movieId, long awardId);

	// white list
	List<AwardTO> getWhiteListedBy(long movieId, long awardId);


	// reviews
	List<AwardTO> getReviews(long movieId, long awardId);
	
	List<MovieReviewTO> addReview(long movieId, long userId, int rating, String comment);

	List<MovieReviewTO> removeReview(long movieId, long userId);

	
	List<MovieTO> getByDate(Date earliest, Date latest);

	List<MovieTO> getByCensorRating(String censorRating);

	List<MovieTO> getByBudget(long min, long max);

	List<MovieTO> getByBoxOffice(long min, long max);

	MovieTO updateBoxOffice(long movieId, long newIncome);

	MovieTO addActor(long movieId, long actorId);

	MovieTO removeActor(long movieId, long actorId);

	MovieTO addLang(long movieId, long langId);

	MovieTO removeLang(long movieId, long langId);

	MovieTO addWriter(long movieId, long writerId);

	MovieTO removeWriter(long movieId, long writerId);


}
