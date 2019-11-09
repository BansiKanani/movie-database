package com.brk.mdb.Services;

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
	private FeedbackRepository feedbackRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public FeedbackTO insertOne(long userId, String message) {
		User u = userRepo.findById(userId).orElseThrow();
		Feedback fb = new Feedback(u, message);
		feedbackRepo.save(fb);
		u.getFeedbacks().add(fb);
		return new FeedbackTO(fb);
	}

	@Override
	public List<FeedbackTO> getByUser(long userId) {
		User u = userRepo.findById(userId).orElseThrow();
		return feedbackRepo.findByUser(u).stream().map(fb -> new FeedbackTO(fb)).collect(Collectors.toList());
	}

	@Override
	public List<FeedbackTO> getAll() {
		return feedbackRepo.findAll().stream().map(fb -> new FeedbackTO(fb)).collect(Collectors.toList());
	}

}
