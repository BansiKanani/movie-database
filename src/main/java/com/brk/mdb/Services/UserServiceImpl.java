package com.brk.mdb.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Movie;
import com.brk.mdb.models.User;
import com.brk.mdb.modelsTO.UserTO;
import com.brk.mdb.repositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserTO insertUser(String fname, String lname, String email, long phone, Date dob, String city, String state,
			String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean rateMovie(long userId, long movieId, int rating, String review) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeRating(long userId, long movieId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserTO getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTO getByEmail(long email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTO> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTO> getByAddress(String city, String state, String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTO> getByAge(int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> addToWishlist(long userId, long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> removeFromWishlist(long userId, long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getWishlist(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getRatedMovies(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
