package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.modelsTO.FeedbackTO;

public interface FeedbackService {
	
	FeedbackTO insertOne(long userId, String message);
	
	List<FeedbackTO> getByUser(long userId);
	
	List<FeedbackTO> getAll();
	
}
