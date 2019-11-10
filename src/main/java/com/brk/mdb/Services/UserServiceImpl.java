package com.brk.mdb.Services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Movie;
import com.brk.mdb.models.MovieReview;
import com.brk.mdb.models.User;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.modelsTO.UserTO;
import com.brk.mdb.repositories.MovieRepository;
import com.brk.mdb.repositories.MovieReviewRepository;
import com.brk.mdb.repositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MovieRepository movieRepo;
	
	private MovieReviewRepository movieReviewRepo;

	@Override
	public UserTO insertOne(String fname, String lname, String email, long phone, Date dob, String city, String state,
			String country) {
		User u = new User(fname, lname, email, phone, city, state, country, dob);
		userRepo.save(u);
		return new UserTO(u);
	}

	@Override
	public boolean rateMovie(long userId, long movieId, int rating, String comment) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		User u = userRepo.findById(userId).orElseThrow();
		MovieReview mr = new MovieReview(m, u, rating, comment);
		m.getMovieReview().add(mr);
		u.getMovieReviews().add(mr);
		return true;
	}

	@Override
	public boolean removeRating(long userId, long movieId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		User u = userRepo.findById(userId).orElseThrow();
		MovieReview mr = movieReviewRepo.findByMovieAndUser(m, u);
		m.getMovieReview().remove(mr);
		u.getMovieReviews().remove(mr);
		return true;
	}

	@Override
	public UserTO getById(long userId) {
		return new UserTO(userRepo.findById(userId).orElseThrow());
	}

	@Override
	public UserTO getByEmail(String email) {
		return new UserTO(userRepo.findByEmail(email));
	}

	@Override
	public List<UserTO> getAll() {
		return userRepo.findAll().stream().map(u -> new UserTO(u)).collect(Collectors.toList());
	}

	@Override
	public List<UserTO> getByName(String fname, String lname) {
		return userRepo.findByFnameLikeAndLnameLike(fname, lname).stream().map(u -> new UserTO(u))
				.collect(Collectors.toList());
	}

	@Override
	public List<UserTO> getByAddress(String city, String state, String country) {
		return userRepo.findByCityLikeAndStateLikeAndCountryLike(city, state, country).stream().map(u -> new UserTO(u))
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
	public List<UserTO> getByAge(int minAge, int maxAge) {
		return userRepo.findByDobBetween(getDobFromAge(maxAge), getDobFromAge(minAge)).stream().map(u -> new UserTO(u))
				.collect(Collectors.toList());
	}

	@Override
	public boolean addToWishlist(long userId, long movieId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		User u = userRepo.findById(userId).orElseThrow();
		m.getWishlistedBy().add(u);
		u.getWishlist().add(m);
		return true;
	}

	@Override
	public boolean removeFromWishlist(long userId, long movieId) {
		Movie m = movieRepo.findById(movieId).orElseThrow();
		User u = userRepo.findById(userId).orElseThrow();
		m.getWishlistedBy().remove(u);
		u.getWishlist().remove(m);
		return true;
	}

	@Override
	public List<MovieTO> getWishlist(long userId) {
		return userRepo.findById(userId).orElseThrow().getWishlist().stream().map(m -> new MovieTO(m))
				.collect(Collectors.toList());
	}

	@Override
	public List<MovieTO> getRatedMovies(long userId) {
		return userRepo.findById(userId).orElseThrow().getMovieReviews().stream().map(mr -> new MovieTO(mr.getMovie()))
				.collect(Collectors.toList());
	}
}
