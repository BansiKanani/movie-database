package com.brk.mdb.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

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
	private Set<Feedback> feedbacks;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<MovieReview> movieReviews;

	@ManyToMany
	@JoinTable(name = "user_wishlist", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<Movie> wishlist;

	public User(boolean status, String fname, String lname, String email, long phone, String city, String state,
			String country, Date dob, Set<Feedback> feedbacks, Set<MovieReview> movieReviews, Set<Movie> wishlist) {
		super();
		this.status = status;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.country = country;
		this.dob = dob;
		this.feedbacks = feedbacks;
		this.movieReviews = movieReviews;
		this.wishlist = wishlist;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", status=" + status + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", phone=" + phone + ", city=" + city + ", state=" + state + ", country=" + country + ", dob=" + dob
				+ ", feedbacks=" + feedbacks + ", movieReviews=" + movieReviews + ", wishlist=" + wishlist + "]";
	}
	
}