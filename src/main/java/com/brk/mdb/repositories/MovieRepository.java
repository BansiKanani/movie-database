package com.brk.mdb.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	// name
	List<Movie> findByNameLike(String name);

	// runtime
	List<Movie> findByRunTimeLessThanEqual(int length);

	List<Movie> findByRunTimeGreaterThanEqual(int length);

	List<Movie> findByRunTimeGreaterThanEqualAndRunTimeLessThanEqual(int minLength, int maxLength);

	// box office
	List<Movie> findByBoxOfficeGreaterThanEqual(long boxOffice);

	List<Movie> findByBoxOfficeLessThanEqual(long boxOffice);
	
	List<Movie> findByBoxOfficeGreaterThanEqualAndBoxOfficeLessThanEqual(int min, int max);

	// budget
	List<Movie> findByBudgetGreaterThanEqual(long budget);

	List<Movie> findByBudgetLessThanEqual(long budget);

	List<Movie> findByBudgetGreaterThanEqualAndBudgetLessThanEqual(int min, int max);
	
	// censor rating
	List<Movie> findByCensorRating(String censorRating);

	// release date
	List<Movie> findByReleaseDateBefore(Date date);

	List<Movie> findByReleaseDateAfter(Date date);

	List<Movie> findByReleaseDateBetween(Date start, Date end);

}
