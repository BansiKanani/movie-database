package com.brk.mdb.tests;

import java.util.List;

import com.brk.mdb.Services.MovieService;
import com.brk.mdb.Services.UserService;
import com.brk.mdb.models.Movie;
import com.brk.mdb.models.User;

public class GeneralTests {

	public static void bulkInsert(UserService uS, MovieService mS) {	
		uS.insertUser(new User("u1", "u1@mail.com"));
		uS.insertUser(new User("u2", "u2@mail.com"));
		uS.insertUser(new User("u3", "u3@mail.com"));
		uS.insertUser(new User("u4", "u4@mail.com"));
		
		mS.insertOne(new Movie("The Titanic", 120, uS.getByName("u1")));
		mS.insertOne(new Movie("The Titanic 2", 120, uS.getByName("u1")));

		mS.insertOne(new Movie("Harry Potter 1", 120, uS.getByName("u2")));
		
		mS.insertOne(new Movie("Harry Potter 2", 120, uS.getByName("u3")));
		
	}
	
	public static void printUsers(List<User> users) {
		for (User u : users) {
			System.out.println(u.toString());
		}
	}
	
	
	public static void printAllMovies(List<Movie> movies) {
		for (Movie m : movies) {
			System.out.println(m.toString());
		}
	}
}
