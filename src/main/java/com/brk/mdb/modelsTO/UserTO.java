package com.brk.mdb.modelsto;

import java.util.Date;
import java.util.Set;

public class UserTO {

	private long id;

	private boolean status;
	private String fname;
	private String lname;
	private String email;
	private long phone;

	private String city;
	private String state;
	private String country;

	private Date dob;

	private Set<FeedbackTO> feedbacks;

	private Set<MovieReviewTO> movieReviews;

	private Set<MovieTO> wishlist;

	public UserTO(boolean status, String fname, String lname, String email, long phone, String city, String state,
			String country, Date dob, Set<FeedbackTO> feedbacks, Set<MovieReviewTO> movieReviews,
			Set<MovieTO> wishlist) {
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