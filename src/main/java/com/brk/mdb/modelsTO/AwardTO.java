package com.brk.mdb.modelsto;

import java.util.Set;

public class AwardTO {

	private long id;

	private String name;

	private Set<MovieAwardTO> movieAwards;

	public AwardTO(String name) {
		super();
		this.name = name;
	}
}