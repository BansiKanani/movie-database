package com.brk.mdb.modelsTO;

import com.brk.mdb.models.Award;

import lombok.Data;

@Data
public class AwardTO {

	private long id;
	private String name;

	public AwardTO(Award a) {
		this.id = a.getId();
		this.name = a.getName();
	}

	public AwardTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AwardTO [id=" + id + ", name=" + name + "]";
	}
}