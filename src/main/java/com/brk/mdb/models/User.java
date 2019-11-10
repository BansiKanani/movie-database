package com.brk.mdb.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private boolean status;
	private String fname;
	private String lname;
	private String email;
	private long phone;

	private String city;
	private String state;
	private String country;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@OneToMany(mappedBy = "user")
	private List<Feedback> feedbacks;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<MovieReview> movieReviews;

	@ManyToMany
	@JoinTable(name = "user_wishlist", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movie> wishlist;

	public User(String fname, String lname, String email, long phone, String city, String state, String country,
			Date dob) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.country = country;
		this.dob = dob;
		this.status = true;
		this.feedbacks = new ArrayList<>();
		this.movieReviews = new ArrayList<>();
		this.wishlist = new ArrayList<>();
	}
}