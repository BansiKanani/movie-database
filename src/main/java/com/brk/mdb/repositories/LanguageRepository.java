package com.brk.mdb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brk.mdb.models.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

	List<Language> findByNameLike(String name);
}