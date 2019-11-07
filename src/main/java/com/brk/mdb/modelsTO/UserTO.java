package com.brk.mdb.modelsTO;

import lombok.Data;

import java.util.Date;

import com.brk.mdb.models.User;

@Data
public class UserTO {

	private long id;
	private boolean status;
	private String fname;
	private String lname;
	private Date dob;
	private String email;
	private long phone;
	private String city;
	private String state;
	private String country;

	public UserTO(User u) {
		this.id=u.getId();
		this.status =u.isStatus();
		this.fname = u.getFname();
		this.lname = u.getLname();
		this.dob = u.getDob();
		this.email = u.getEmail();
		this.phone = u.getPhone();
		this.city = u.getCity();
		this.state = u.getState();
		this.country = u.getCountry();
	}

}