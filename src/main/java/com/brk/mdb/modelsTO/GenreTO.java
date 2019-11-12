package com.brk.mdb.modelsTO;

import com.brk.mdb.models.Genre;

import lombok.Data;

@Data
public class GenreTO {

	private long id;
	private String name;

	public GenreTO(Genre g) {
		this.id = g.getId();
		this.name = g.getName();
	}

	public GenreTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GenreTO [id=" + id + ", name=" + name + "]";
	}
}