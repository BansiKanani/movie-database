package com.brk.mdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.MovieAward;;

@Repository
public interface MovieAwardRepository extends JpaRepository<MovieAward, Long> {

}
