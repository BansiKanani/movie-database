package com.brk.mdb.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;

	@ManyToMany(mappedBy = "genres")
	private List<Movie> movies;

	public Genre(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + ", movies=" + movies + "]";
	}
}