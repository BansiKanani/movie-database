package com.brk.mdb.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Language;
import com.brk.mdb.modelsTO.LanguageTO;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.repositories.LanguageRepository;

@Service("languageService")
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository lR;

	@Override
	public LanguageTO insertOne(String name) {
		Language l = new Language(name);
		lR.saveAndFlush(l);
		return new LanguageTO(l);
	}

	@Override
	public List<MovieTO> getMovies(long langId) {
		return lR.findById(langId).orElseThrow().getMovies().stream().map(m -> new MovieTO(m))
				.collect(Collectors.toList());
	}

	@Override
	public LanguageTO getById(long langId) {
		return new LanguageTO(lR.findById(langId).orElseThrow());
	}

	@Override
	public List<LanguageTO> getByName(String name) {
		return lR.findByNameLike("%" + name + "%").stream().map(l -> new LanguageTO(l)).collect(Collectors.toList());
	}

	@Override
	public List<LanguageTO> getAll() {
		return lR.findAll().stream().map(l -> new LanguageTO(l)).collect(Collectors.toList());
	}

}
