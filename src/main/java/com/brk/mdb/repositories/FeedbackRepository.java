package com.brk.mdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
