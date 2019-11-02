package com.brk.mdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.brk.mdb.Services.MovieService;
import com.brk.mdb.Services.UserService;
import com.brk.mdb.tests.GeneralTests;

@Controller
public class GeneralController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/index")
	public String indexPage(Model model) {

		// for testing
		GeneralTests.bulkInsert(userService, movieService);

		GeneralTests.printAllMovies(movieService.getByName("Titanic"));

		GeneralTests.printAllMovies(movieService.getLengthInBetween(130, 170));
		
		return "index";
	}
}
