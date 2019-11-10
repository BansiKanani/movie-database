package com.brk.mdb.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.brk.mdb.Services.ActorService;
import com.brk.mdb.Services.AwardService;
import com.brk.mdb.Services.DirectorService;
import com.brk.mdb.Services.FeedbackService;
import com.brk.mdb.Services.GenreService;
import com.brk.mdb.Services.LanguageService;
import com.brk.mdb.Services.MovieService;
import com.brk.mdb.Services.ProductionService;
import com.brk.mdb.Services.UserService;
import com.brk.mdb.Services.WriterService;
import com.brk.mdb.tests.GeneralTests;

@Controller
public class GeneralController {

	@Autowired
	private ActorService actorService;

	@Autowired
	private AwardService awardService;

	@Autowired
	private DirectorService directorService;

	@Autowired
	private FeedbackService feedbackService;

	@Autowired
	private GenreService genreService;

	@Autowired
	private LanguageService languageService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private ProductionService productionService;

	@Autowired
	private UserService userService;

	@Autowired
	private WriterService writerService;

	@GetMapping("/index")
	public String indexPage(Model model) {

		// for testing
		try {
			GeneralTests.bulkInsert(userService, movieService, actorService, awardService, directorService, feedbackService,
					genreService, languageService, productionService, writerService);
		} catch (ParseException e) {
			e.printStackTrace();
		}

//		GeneralTests.printAllMovies(movieService.getByName("Titanic"));
//
//		GeneralTests.printAllMovies(movieService.getLengthInBetween(130, 170));

		return "index";
	}
}
