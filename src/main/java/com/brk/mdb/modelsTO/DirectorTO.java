package com.brk.mdb.modelsTO;

import com.brk.mdb.models.Director;

import lombok.Data;

@Data
public class DirectorTO {

	private long id;
	private String name;

	public DirectorTO(Director d) {
		this.id = d.getId();
		this.name = d.getName();
	}

	public DirectorTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DirectorTO [id=" + id + ", name=" + name + "]";
	}
}