package com.brk.mdb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

	List<Director> findByNameLike(String name);
}
