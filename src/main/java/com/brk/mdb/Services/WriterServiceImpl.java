package com.brk.mdb.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Writer;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.modelsTO.WriterTO;
import com.brk.mdb.repositories.WriterRepository;

@Service("writerService")
public class WriterServiceImpl implements WriterService {

	@Autowired
	private WriterRepository writerRepo;

	@Override
	public WriterTO insertOne(String name) {
		Writer w = new Writer(name);
		writerRepo.save(w);
		return new WriterTO(w);
	}

	@Override
	public WriterTO getById(long writerId) {
		return new WriterTO(writerRepo.findById(writerId).orElseThrow());
	}

	@Override
	public List<WriterTO> getByName(String name) {
		return writerRepo.findByNameLike("%" + name + "%").stream().map(w -> new WriterTO(w))
				.collect(Collectors.toList());
	}

	@Override
	public List<WriterTO> getAll() {
		return writerRepo.findAll().stream().map(w -> new WriterTO(w)).collect(Collectors.toList());
	}

	@Override
	public List<MovieTO> getMovies(long writerId) {
		return writerRepo.findById(writerId).orElseThrow().getMovies().stream().map(m -> new MovieTO(m))
				.collect(Collectors.toList());
	}

}
