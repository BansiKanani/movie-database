package com.brk.mdb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.Production;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {

	List<Production> findByNameLike(String name);
}