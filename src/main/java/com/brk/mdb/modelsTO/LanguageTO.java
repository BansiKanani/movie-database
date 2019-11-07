package com.brk.mdb.modelsTO;

import com.brk.mdb.models.Language;

import lombok.Data;

@Data
public class LanguageTO {

	private long id;
	private String name;

	public LanguageTO(Language l) {
		this.id = l.getId();
		this.name = l.getName();
	}
}