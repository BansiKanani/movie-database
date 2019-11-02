package com.brk.mdb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByName(String name);
}
