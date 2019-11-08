package com.brk.mdb.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

	List<Actor> findByNameLike(String name);
	
	// city
	List<Actor> findByCityLike(String city);

	// state
	List<Actor> findByStateLike(String state);

	// country
	List<Actor> findByCountryLike(String country);
	
	// address
	List<Actor> findByCountryLikeAndStateLikeAndCityLike(String country, String state, String city);
	
	// height
	List<Actor> findByHeightGreaterThanEqual(long boxOffice);

	List<Actor> findByHeightLessThanEqual(long budget);

	List<Actor> findByHeightGreaterThanEqualAndHeightLessThanEqual(int min, int max);
	
	// dob
	List<Actor> findByDobBetween(Date start, Date end);
	
}
