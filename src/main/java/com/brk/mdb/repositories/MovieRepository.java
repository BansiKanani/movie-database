package com.brk.mdb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.Movie;
import com.brk.mdb.models.User;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	List<Movie> findByNameLike(String name);

	List<Movie> findByLengthLessThanEqual(int length);
	
	List<Movie> findByLengthGreaterThanEqual(int length);
	
	List<Movie> findByLengthGreaterThanEqualAndLengthLessThanEqual(int minLength, int maxLength);
	
	List<Movie> findByMadeby(User user);
}
