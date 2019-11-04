package com.brk.mdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.MovieReview;;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {

}
