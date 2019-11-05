package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.brk.mdb.models.Actor;
import com.brk.mdb.models.Award;
import com.brk.mdb.models.Director;
import com.brk.mdb.models.Genre;
import com.brk.mdb.models.Language;
import com.brk.mdb.models.Movie;
import com.brk.mdb.models.Production;
import com.brk.mdb.models.User;
import com.brk.mdb.models.Writer;

public interface MovieService {

	MovieTO insertOne(String name, int runTime, long budget, long boxOffice, String censorRating, String story,
			Date releaseDate, Set<Genre> genres, long directorId, long productionId);

	List<MovieTO> getAll();
	
	Optional<MovieTO> getById(long id);
	
	List<MovieTO> getByRunTime(int minLength, int maxLength);
	
	List<MovieTO> addAward(long movieId, long awardId, Date d);
	
	List<MovieTO> removeAward(long movieId, Date d);
	
	List<MovieTO> addWhiteListedBy(long movieId, long userId);
	
	List<MovieTO> removeWhiteListedBy(long movieId, long userId);
	
	List<MovieTO> addReview(long movieId, long userId, int rating, String comment);
	
	List<MovieTO> removeReview(long movieId, long userId);
	
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

	List<MovieTO> getByName(String name);


}
