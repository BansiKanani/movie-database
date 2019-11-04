package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Feedback;
import com.brk.mdb.models.User;

public interface FeedbackService {
	
	Feedback insertOne(User u, String message);
	
	List<Feedback> getByUser(User u);
	
	List<Feedback> getAll();
	
}
