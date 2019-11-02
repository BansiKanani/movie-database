package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Movie;
import com.brk.mdb.models.User;

public interface UserService {

	void insertUser(User u);

	List<User> getAll();
	
	List<User> getByName(String name);
	
	List<Movie> getWishlist(User u);
	
	List<Movie> addToWishlist(User u, Movie m);
	
	List<Movie> removeFromWishlist(User u, Movie m);
	
	List<Movie> getRatedMovies(User u);
	
	Boolean rateMovie(User u, Movie m, int rating, String review);
	
}
