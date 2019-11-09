package com.brk.mdb.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Genre;
import com.brk.mdb.modelsTO.GenreTO;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.repositories.GenreRepository;

@Service("genreService")
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository genreRepo;

	@Override
	public GenreTO insertOne(String name) {
		Genre g = new Genre(name);
		genreRepo.save(g);
		return new GenreTO(g);
	}

	@Override
	public List<MovieTO> getMovies(long genreId) {
		return genreRepo.findById(genreId).orElseThrow().getMovies().stream().map(m -> new MovieTO(m))
				.collect(Collectors.toList());
	}

	@Override
	public GenreTO getById(long genreId) {
		return new GenreTO(genreRepo.findById(genreId).orElseThrow());
	}

	@Override
	public List<GenreTO> getByName(String name) {
		return genreRepo.findByNameLike("%" + name + "%").stream().map(g -> new GenreTO(g))
				.collect(Collectors.toList());
	}

	@Override
	public List<GenreTO> getAll() {
		return genreRepo.findAll().stream().map(g -> new GenreTO(g)).collect(Collectors.toList());
	}

}
