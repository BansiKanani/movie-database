package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;

import com.brk.mdb.models.Movie;
import com.brk.mdb.modelsTO.UserTO;

public interface UserService {

	UserTO insertUser(String fname, String lname, String email, long phone, Date dob, String city, String state,
			String country);

	boolean rateMovie(long userId, long movieId, int rating, String review);

	boolean removeRating(long userId, long movieId);

	UserTO getById(long id);

	UserTO getByEmail(long email);

	List<UserTO> getAll();

	List<UserTO> getByName(String name);

	List<UserTO> getByAddress(String city, String state, String country);

	List<UserTO> getByAge(int minAge, int maxAge);

	List<Movie> addToWishlist(long userId, long movieId);

	List<Movie> removeFromWishlist(long userId, long movieId);

	List<Movie> getWishlist(long userId);

	List<Movie> getRatedMovies(long userId);
}
