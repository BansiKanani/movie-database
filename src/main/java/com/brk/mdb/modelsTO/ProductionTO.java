package com.brk.mdb.modelsTO;

import com.brk.mdb.models.Production;

import lombok.Data;

@Data
public class ProductionTO {

	private long id;
	private String name;

	public ProductionTO(Production p) {
		this.id = p.getId();
		this.name = p.getName();
	}

	public ProductionTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductionTO [id=" + id + ", name=" + name + "]";
	}
}