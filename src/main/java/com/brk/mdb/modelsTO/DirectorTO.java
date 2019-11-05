package com.brk.mdb.modelsto;

import java.util.Set;

public class DirectorTO {

	private long id;

	private String name;

	private Set<MovieTO> movies;

	public DirectorTO(String name) {
		super();
		this.name = name;
	}
}