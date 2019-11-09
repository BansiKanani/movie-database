package com.brk.mdb.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Data
@Entity
public class Director {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;
	
	@OneToMany(mappedBy = "director")
	private List<Movie> movies;

	public Director(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Director [id=" + id + ", name=" + name + ", movies=" + movies + "]";
	}
}