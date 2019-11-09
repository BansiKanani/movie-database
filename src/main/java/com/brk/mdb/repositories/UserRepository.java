package com.brk.mdb.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// name
	List<User> findByFnameLikeAndLnameLike(String fname, String lname);
	
	// email
	User findByEmail(String email);

	// phone
	User findByPhone(long phone);

	// address
	List<User> findByCityLike(String city);
	List<User> findByStateLike(String state);
	List<User> findByCountryLike(String country);
	List<User> findByCityLikeAndStateLikeAndCountryLike(String city, String state, String country);

	// dob
	List<User> findByDobBefore(Date date);

	List<User> findByDobAfter(Date date);

	List<User> findByDobBetween(Date start, Date end);
}
