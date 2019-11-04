package com.brk.mdb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

	List<Genre> findByNameLike(String name);
}
