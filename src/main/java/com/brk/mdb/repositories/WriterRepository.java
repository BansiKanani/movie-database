package com.brk.mdb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.Writer;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {

	List<Writer> findByNameLike(String name);
}
