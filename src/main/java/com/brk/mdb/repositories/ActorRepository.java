package com.brk.mdb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

	List<Actor> findByNameLike(String name);
}
