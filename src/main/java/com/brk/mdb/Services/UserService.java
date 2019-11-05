package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;

import com.brk.mdb.models.Movie;
import com.brk.mdb.models.User;

public interface UserService {

	User insertUser(String fname, String lname, String email, long phone, Date dob, String city, String state,
			String country);

	boolean rateMovie(User u, Movie m, int rating, String review);

	boolean removeRating(User u, Movie m);

	User getById(long id);

	User getByEmail(long email);

	List<User> getAll();

	List<User> getByName(String name);

	List<User> getByAddress(String city, String state, String country);

	List<User> getByAge(int minAge, int maxAge);

	List<Movie> addToWishlist(User u, Movie m);

	List<Movie> removeFromWishlist(User u, Movie m);

	List<Movie> getWishlist(User u);

	List<Movie> getRatedMovies(User u);
}
