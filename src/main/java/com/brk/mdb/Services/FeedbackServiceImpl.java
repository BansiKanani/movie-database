package com.brk.mdb.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.Feedback;
import com.brk.mdb.models.User;
import com.brk.mdb.modelsTO.FeedbackTO;
import com.brk.mdb.repositories.FeedbackRepository;
import com.brk.mdb.repositories.UserRepository;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository fR;

	@Autowired
	private UserRepository uR;

	
	@Override
	public FeedbackTO insertOne(long userId, String message) {
		
		User u = uR.findById(userId).orElseThrow();
		Feedback fb = new Feedback(u, message);
		fR.save(fb);
		return new FeedbackTO(fb);
	}

	@Override
	public List<FeedbackTO> getByUser(long userId) {

//		List<FeedbackTO> fbTOs = new ArrayList<FeedbackTO>();

		User u = uR.findById(userId).orElseThrow();
		return fR.findByUser(u).stream().map(fb -> new FeedbackTO(fb)).collect(Collectors.toList());
	}

	@Override
	public List<FeedbackTO> getAll() {

//		List<Feedback> fbs = fR.findAll();
//		List<FeedbackTO> fbTOs = fbs.stream().map(fb -> new FeedbackTO(fb)).collect(Collectors.toList());
//		return fbTOs;
		
		return fR.findAll().stream().map(fb -> new FeedbackTO(fb)).collect(Collectors.toList());
	}

}
