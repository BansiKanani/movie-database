package com.brk.mdb.modelsto;

import java.util.List;

public class WriterTO {

	private long id;

	private String name;

	private List<MovieTO> wrote;

	public WriterTO(String name) {
		super();
		this.name = name;
	}
}
