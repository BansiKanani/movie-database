package com.brk.mdb.modelsto;

import java.util.Set;

public class GenreTO {

	private long id;

	private String name;

	private Set<MovieTO> movies;

	public GenreTO(String name) {
		super();
		this.name = name;
	}
}