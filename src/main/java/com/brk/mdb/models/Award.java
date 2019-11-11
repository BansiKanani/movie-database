package com.brk.mdb.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Award {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;

	@OneToMany(mappedBy = "award", cascade = CascadeType.ALL)
	private List<MovieAward> movieAwards;

	public Award(String name) {
		this.name = name;
		this.movieAwards = new ArrayList<>();
	}

	public Award() {
		super();
	}
}