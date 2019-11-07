package com.brk.mdb.modelsTO;

import com.brk.mdb.models.Writer;

import lombok.Data;

@Data
public class WriterTO {

	private long id;
	private String name;

	public WriterTO(Writer w) {
		this.id = w.getId();
		this.name = w.getName();
	}
}
