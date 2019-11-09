package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;

import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.modelsTO.UserTO;

public interface UserService {

	UserTO insertUser(String fname, String lname, String email, long phone, Date dob, String city, String state,
			String country);

	boolean rateMovie(long userId, long movieId, int rating, String comment);

	boolean removeRating(long userId, long movieId);

	UserTO getById(long userId);

	UserTO getByEmail(String email);

	List<UserTO> getAll();

	List<UserTO> getByName(String fname, String lname);

	List<UserTO> getByAddress(String city, String state, String country);

	List<UserTO> getByAge(int minAge, int maxAge);

	boolean addToWishlist(long userId, long movieId);

	boolean removeFromWishlist(long userId, long movieId);

	List<MovieTO> getWishlist(long userId);

	List<MovieTO> getRatedMovies(long userId);

}
