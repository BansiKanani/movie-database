package com.brk.mdb.modelsto;

import java.util.Set;

public class ProductionTO {

	private long id;

	private String name;

	private Set<MovieTO> movies;

	public ProductionTO(String name) {
		super();
		this.name = name;
	}
}