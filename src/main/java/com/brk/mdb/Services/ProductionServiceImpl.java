package com.brk.mdb.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Production;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.modelsTO.ProductionTO;
import com.brk.mdb.repositories.ProductionRepository;

@Service("productionService")
public class ProductionServiceImpl implements ProductionService {

	@Autowired
	private ProductionRepository pR;

	@Override
	public ProductionTO insertOne(String name) {
		Production p = new Production(name);
		pR.save(p);
		return new ProductionTO(p);
	}

	@Override
	public ProductionTO getById(long productionId) {
		return new ProductionTO(pR.findById(productionId).orElseThrow());
	}

	@Override
	public List<ProductionTO> getByName(String name) {
		return pR.findByNameLike("%" + name + "%").stream().map(p -> new ProductionTO(p)).collect(Collectors.toList());
	}

	@Override
	public List<ProductionTO> getAll() {
		return pR.findAll().stream().map(p -> new ProductionTO(p)).collect(Collectors.toList());
	}

	@Override
	public List<MovieTO> getMovies(long productionId) {
		return pR.findById(productionId).orElseThrow().getMovies().stream().map(m -> new MovieTO(m))
				.collect(Collectors.toList());
	}

}
