package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Actor;
import com.brk.mdb.models.Award;
import com.brk.mdb.models.Director;
import com.brk.mdb.models.Genre;
import com.brk.mdb.models.Language;
import com.brk.mdb.models.Movie;
import com.brk.mdb.models.MovieAward;
import com.brk.mdb.models.MovieReview;
import com.brk.mdb.models.Production;
import com.brk.mdb.models.User;
import com.brk.mdb.models.Writer;
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
import com.brk.mdb.repositories.ActorRepository;
import com.brk.mdb.repositories.AwardRepository;
import com.brk.mdb.repositories.DirectorRepository;
import com.brk.mdb.repositories.GenreRepository;
import com.brk.mdb.repositories.LanguageRepository;
import com.brk.mdb.repositories.MovieAwardRepository;
import com.brk.mdb.repositories.MovieRepository;
import com.brk.mdb.repositories.MovieReviewRepository;
import com.brk.mdb.repositories.ProductionRepository;
import com.brk.mdb.repositories.UserRepository;
import com.brk.mdb.repositories.WriterRepository;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private AwardRepository awardRepo;

	@Autowired
	private ActorRepository actorRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private GenreRepository genreRepo;

	@Autowired
	private LanguageRepository languageRepo;

	@Autowired
	private WriterRepository writerRepo;

	@Autowired
	private ProductionRepository productionRepo;

	@Autowired
	private DirectorRepository directorRepo;

	@Autowired
	private MovieReviewRepository movieReviewRepo;

	@Autowired
	private MovieAwardRepository movieAwardRepo;

	@Override
	public MovieTO insertOne(String name, int runTime, long budget, long boxOffice, String censorRating, String story,
			Date releaseDate) {
		Movie m = new Movie(name, runTime, budget, boxOffice, censorRating, story, releaseDate);
		movieRepo.save(m);
		return new MovieTO(m);
	}

	@Override
	public List<MovieTO> getAll() {
		return movieRepo.findAll().stream().map(m -> new MovieTO(m)).collect(Collectors.toList());
	}

	@Override
	public MovieTO getById(long movieId) {
		return new MovieTO(movieRepo.findById(movieId).orElseThrow());
	}

	@Override
	public List<MovieTO> getByRunTime(int minLength, int maxLength) {
		return movieRepo.findByRunTimeGreaterThanEqualAndRunTimeLessThanEqual(minLength, maxLength).stream()
				.map(m -> new MovieTO(m)).collect(Collectors.toList());
	}

	@Override
	public List<AwardTO> getAwards(long movieId) {
		return movieRepo.findById(movieId).orElseThrow().getMovieAwards().stream().map(ma -> new AwardTO(ma.getAward()))
				.collect(Collectors.toList());
	}

	@Override
	public boolean addAward(long movieId, long awardId, Date d) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		Award a = awardRepo.findById(awardId).orElseThrow();
		MovieAward ma = new MovieAward(m, a, d);
		a.getMovieAwards().add(ma);
		m.getMovieAwards().add(ma);
		movieRepo.flush();
		awardRepo.flush();
		return true;

	}

	@Override
	public boolean removeAward(long movieId, long awardId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		Award a = awardRepo.findById(awardId).orElseThrow();
		MovieAward ma = movieAwardRepo.findByMovieAndAward(m, a);
		m.getMovieAwards().remove(ma);
		a.getMovieAwards().remove(ma);
		movieRepo.flush();
		awardRepo.flush();
		return true;

	}

	@Override
	public List<MovieReviewTO> getReviews(long movieId) {
		return movieRepo.findById(movieId).orElseThrow().getMovieReview().stream().map(mr -> new MovieReviewTO(mr))
				.collect(Collectors.toList());
	}

	@Override
	public boolean addReview(long movieId, long userId, int rating, String comment) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		User u = userRepo.findById(userId).orElseThrow();
		MovieReview movRev = new MovieReview(m, u, rating, comment);
		m.getMovieReview().add(movRev);
		u.getMovieReviews().add(movRev);
		movieRepo.flush();
		userRepo.flush();
		return true;

	}

	@Override
	public boolean removeReview(long movieId, long userId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		User u = userRepo.findById(userId).orElseThrow();
		MovieReview movRev = movieReviewRepo.findByMovieAndUser(m, u);
		m.getMovieReview().remove(movRev);
		u.getMovieReviews().remove(movRev);
		movieRepo.flush();
		userRepo.flush();
		return true;

	}

	@Override
	public List<MovieTO> getByDate(Date earliest, Date latest) {
		return movieRepo.findByReleaseDateBetween(earliest, latest).stream().map(m -> new MovieTO(m))
				.collect(Collectors.toList());
	}

	@Override
	public List<MovieTO> getByCensorRating(String censorRating) {
		return movieRepo.findByCensorRating(censorRating).stream().map(m -> new MovieTO(m))
				.collect(Collectors.toList());
	}

	@Override
	public List<MovieTO> getByBudget(long min, long max) {
		return movieRepo.findByBudgetGreaterThanEqualAndBudgetLessThanEqual(min, max).stream().map(m -> new MovieTO(m))
				.collect(Collectors.toList());
	}

	@Override
	public List<MovieTO> getByBoxOffice(long min, long max) {
		return movieRepo.findByBoxOfficeGreaterThanEqualAndBoxOfficeLessThanEqual(min, max).stream()
				.map(m -> new MovieTO(m)).collect(Collectors.toList());
	}

	@Override
	public boolean updateBoxOffice(long movieId, long newIncome) {
		movieRepo.findById(movieId).orElseThrow().setBoxOffice(newIncome);
		return true;

	}

	@Override
	public List<ActorTO> getActors(long movieId) {
		return movieRepo.findById(movieId).orElseThrow().getActors().stream().map(a -> new ActorTO(a))
				.collect(Collectors.toList());
	}

	@Override
	public boolean addActor(long movieId, long actorId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		Actor a = actorRepo.findById(actorId).orElseThrow();
		m.getActors().add(a);
		a.getMovies().add(m);
		movieRepo.flush();
		actorRepo.flush();
		return true;
	}

	@Override
	public boolean removeActor(long movieId, long actorId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		Actor a = actorRepo.findById(actorId).orElseThrow();
		m.getActors().remove(a);
		a.getMovies().remove(m);
		movieRepo.flush();
		actorRepo.flush();
		return true;

	}

	@Override
	public List<LanguageTO> getLanguages(long movieId) {
		return movieRepo.findById(movieId).orElseThrow().getLanguages().stream().map(l -> new LanguageTO(l))
				.collect(Collectors.toList());
	}

	@Override
	public boolean addLanguage(long movieId, long languageId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		Language l = languageRepo.findById(languageId).orElseThrow();
		m.getLanguages().add(l);
		l.getMovies().add(m);
		languageRepo.flush();
		movieRepo.flush();
		return true;

	}

	@Override
	public boolean removeLanguage(long movieId, long languageId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		Language l = languageRepo.findById(languageId).orElseThrow();
		m.getLanguages().remove(l);
		l.getMovies().remove(m);
		languageRepo.flush();
		movieRepo.flush();
		return true;
	}

	@Override
	public List<WriterTO> getWriters(long movieId) {
		return movieRepo.findById(movieId).orElseThrow().getWriters().stream().map(w -> new WriterTO(w))
				.collect(Collectors.toList());
	}

	@Override
	public boolean addWriter(long movieId, long writerId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		Writer w = writerRepo.findById(writerId).orElseThrow();
		m.getWriters().add(w);
		w.getMovies().add(m);
		writerRepo.flush();
		movieRepo.flush();
		return true;
	}

	@Override
	public boolean removeWriter(long movieId, long writerId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		Writer w = writerRepo.findById(writerId).orElseThrow();
		m.getWriters().remove(w);
		w.getMovies().remove(m);
		writerRepo.flush();
		movieRepo.flush();
		return true;
	}

	@Override
	public List<MovieTO> getByName(String name) {
		return movieRepo.findByNameLike("%" + name + "%").stream().map(m -> new MovieTO(m))
				.collect(Collectors.toList());
	}

	@Override
	public List<UserTO> getWishListedBy(long movieId) {
		return movieRepo.findById(movieId).orElseThrow().getWishlistedBy().stream().map(u -> new UserTO(u))
				.collect(Collectors.toList());
	}

	@Override
	public List<GenreTO> getGenres(long movieId) {
		return movieRepo.findById(movieId).orElseThrow().getGenres().stream().map(g -> new GenreTO(g))
				.collect(Collectors.toList());
	}

	@Override
	public boolean addGenre(long movieId, long genreId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		Genre g = genreRepo.findById(genreId).orElseThrow();
		m.getGenres().add(g);
		g.getMovies().add(m);
		genreRepo.flush();
		movieRepo.flush();
		return true;
	}

	@Override
	public boolean removeGenre(long movieId, long genreId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		Genre g = genreRepo.findById(genreId).orElseThrow();
		m.getGenres().remove(g);
		g.getMovies().remove(m);
		genreRepo.flush();
		movieRepo.flush();
		return true;
	}

	@Override
	public DirectorTO getDirector(long movieId) {
		return new DirectorTO(movieRepo.findById(movieId).orElseThrow().getDirector());
	}

	@Override
	public boolean setDirector(long movieId, long directorId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		Director d = directorRepo.findById(directorId).orElseThrow();
		m.setDirector(d);
		d.getMovies().add(m);
		directorRepo.flush();
		movieRepo.flush();
		return true;
	}

	@Override
	public ProductionTO getProduction(long movieId) {
		return new ProductionTO(movieRepo.findById(movieId).orElseThrow().getProduction());
	}

	@Override
	public boolean setProduction(long movieId, long productionId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		Production p = productionRepo.findById(productionId).orElseThrow();
		m.setProduction(p);
		p.getMovies().add(m);
		productionRepo.flush();
		movieRepo.flush();
		return true;
	}

}
