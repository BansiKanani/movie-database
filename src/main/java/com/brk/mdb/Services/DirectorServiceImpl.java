package com.brk.mdb.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Director;
import com.brk.mdb.modelsTO.DirectorTO;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.repositories.DirectorRepository;

@Service("directorService")
public class DirectorServiceImpl implements DirectorService {

	@Autowired
	private DirectorRepository directorRepo;

	@Override
	public DirectorTO insertOne(String name) {
		Director d = new Director(name);
		directorRepo.save(d);
		return new DirectorTO(d);
	}

	@Override
	public List<MovieTO> getMovies(long directorId) {
		return directorRepo.findById(directorId).orElseThrow().getMovies().stream().map(m -> new MovieTO(m))
				.collect(Collectors.toList());
	}

	@Override
	public DirectorTO getById(long directorId) {
		return new DirectorTO(directorRepo.findById(directorId).orElseThrow());
	}

	@Override
	public List<DirectorTO> getByName(String name) {
		return directorRepo.findByNameLike("%" + name + "%").stream().map(d -> new DirectorTO(d))
				.collect(Collectors.toList());
	}

	@Override
	public List<DirectorTO> getAll() {
		return directorRepo.findAll().stream().map(d -> new DirectorTO(d)).collect(Collectors.toList());
	}

}
