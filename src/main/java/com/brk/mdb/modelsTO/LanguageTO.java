package com.brk.mdb.modelsto;

import java.util.Set;

public class LanguageTO {

	private long id;

	private String name;

	private Set<MovieTO> movies;

	public LanguageTO(String name) {
		super();
		this.name = name;
	}
}