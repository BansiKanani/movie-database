package com.brk.mdb.controllers;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.tests.GeneralTests;

import com.brk.mdb.models.Genre;
import com.brk.mdb.modelsTO.ActorTO;
import com.brk.mdb.modelsTO.AwardTO;
import com.brk.mdb.modelsTO.DirectorTO;
import com.brk.mdb.modelsTO.FeedbackTO;
import com.brk.mdb.modelsTO.GenreTO;
import com.brk.mdb.modelsTO.LanguageTO;
import com.brk.mdb.modelsTO.ProductionTO;
import com.brk.mdb.modelsTO.WriterTO;
import com.brk.mdb.modelsTO.UserTO;

import javassist.expr.NewArray;

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
	@GetMapping("/404")
	public String say404(Model model) {

		

		return "404";

	}

	@GetMapping("/users")
	public String sayusers(Model model) {

		model.addAttribute("users", userService.getAll());

		return "users";

	}

	@GetMapping("/user")
	public String sayuserprofile(Model model, HttpServletRequest req) {
		long uid = Long.parseLong(req.getParameter("id"));
		model.addAttribute("user", userService.getById(uid));
		//
		// List<MovieTO> mto = userService.getWishlist(uid);
		//
		// for (MovieTO movieTO : mto) {
		// System.out.println(movieTO);
		// }
		// model.addAttribute("wishlistArray", userService.getWishlist(uid));

		return "userprofile";
		// return "usersprof";
	}

	@GetMapping("/actors")
	public String sayactor(Model model) {

		model.addAttribute("actors", actorService.getAll());

		return "actors";

	}

	@GetMapping("/actor")
	public String sayactorprofile(Model model, HttpServletRequest req) {

		model.addAttribute("actor", actorService.getById(Long.parseLong(req.getParameter("id"))));

		// return "actorprofile";
		return "actorprofilesingle";
	}

	@GetMapping("/movies")
	public String saymovie(Model model) {

		model.addAttribute("movies", movieService.getAll());

		return "movies";

	}

	@GetMapping("/movie")
	public String saymoviesingle(Model model, HttpServletRequest req) {

		model.addAttribute("movie", movieService.getById(Long.parseLong(req.getParameter("id"))));

		// return "movieprof";
		return "moviesingle";
	}

	@GetMapping("/explore")
	public String sayexplore() {

		return "explore";
	}

	@GetMapping("/wishlist")
	public String saywishlistmovie(Model model, HttpServletRequest req) {

		// model.addAttribute("user",
		// userService.getWishlist(Long.parseLong(req.getParameter("id"))));

		// return "wishlistprof";
		// return "userfavoritelist";
		// List<MovieTO> uto =
		// userService.getWishlist(Long.parseLong(req.getParameter("id")));

		List<MovieTO> uto = userService.getWishlist(Long.parseLong(req.getParameter("id")));
		// for (MovieTO movies : uto) {
		// System.out.println(movies);
		// }

		model.addAttribute("movies", uto);
		return "wishlistprof";

	}

	@GetMapping("/index")
	public String indexPage(Model model) {

		// for testing
		try {
			GeneralTests.bulkInsert(userService, movieService, actorService, awardService, directorService,
					feedbackService, genreService, languageService, productionService, writerService);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// GeneralTests.printAllMovies(movieService.getByName("Titanic"));
		//
		// GeneralTests.printAllMovies(movieService.getLengthInBetween(130, 170));

		return "index";
	}

	@GetMapping("/adddirector")
	public String DirectorForm(Model model) {
		model.addAttribute("director", new DirectorTO());
		return "adddirector";
	}

	@PostMapping("/adddirector")
	public String processDirector(@ModelAttribute DirectorTO directorto) {
		try {
			directorService.insertOne(directorto.getName());
			return "success";
		} catch (Exception e) {
			return "showmessage";
		}

	}

	@GetMapping("/addactor")
	public String ActorForm(Model model) {
		model.addAttribute("actor", new ActorTO());
		return "addactor";
	}

	@PostMapping("/addactor")
	public String processActor(@ModelAttribute ActorTO actorto) {
		try {
			actorService.insertOne(actorto.getName(), actorto.getDob(), actorto.getHeight(), actorto.getCity(),
					actorto.getState(), actorto.getCountry());
			return "success";
		} catch (Exception e) {
			return "showmessage";
		}

	}

	@GetMapping("/addaward")
	public String AwardForm(Model model) {
		model.addAttribute("award", new AwardTO());
		return "addaward";
	}

	@PostMapping("/addaward")
	public String processAward(@ModelAttribute AwardTO awardto) {
		try {
			awardService.insertOne(awardto.getName());
			return "success";
		} catch (Exception e) {
			return "showmessage";
		}

	}

	@GetMapping("/addfeedback")
	public String FeedbackForm(Model model) {
		model.addAttribute("feedback", new FeedbackTO());
		return "addfeedback";
	}

	@PostMapping("/addfeedback")
	public String procesFeedback(@ModelAttribute FeedbackTO feedbackto) {
		try {
			feedbackService.insertOne(feedbackto.getUser().getId(), feedbackto.getMessage());
			return "success";
		} catch (Exception e) {
			return "showmessage";
		}

	}

	@GetMapping("/addgenre")
	public String GenreForm(Model model) {
		model.addAttribute("genre", new GenreTO());
		return "addgenre";
	}

	@PostMapping("/addgenre")
	public String proocesgenre(@ModelAttribute GenreTO genreto) {
		try {
			genreService.insertOne(genreto.getName());
			return "success";
		} catch (Exception e) {
			return "showmessage";
		}

	}

	@GetMapping("/addlanguage")
	public String LanguageForm(Model model) {
		model.addAttribute("language", new LanguageTO());
		return "addlanguage";
	}

	@PostMapping("/addlanguage")
	public String proceslanguage(@ModelAttribute LanguageTO languageto) {
		try {
			languageService.insertOne(languageto.getName());
			return "success";
		} catch (Exception e) {
			return "showmessage";
		}

	}

	@GetMapping("/addproduction")
	public String ProductionForm(Model model) {
		model.addAttribute("production", new ProductionTO());
		return "addproduction";
	}

	@PostMapping("/addproduction")
	public String procesProduction(@ModelAttribute ProductionTO productionto) {
		try {
			productionService.insertOne(productionto.getName());
			return "success";
		} catch (Exception e) {
			return "showmessage";
		}

	}

	@GetMapping("/addwriter")
	public String WriterForm(Model model) {
		model.addAttribute("writer", new WriterTO());
		return "addwriter";
	}

	@PostMapping("/addwriter")
	public String procesWriter(@ModelAttribute WriterTO writerto) {
		try {
			writerService.insertOne(writerto.getName());
			return "success";
		} catch (Exception e) {
			return "showmessage";
		}

	}

//	@GetMapping("/adduser")
//	public String UserForm(Model model) {
//		model.addAttribute("user", new UserTO());
//		return "adduser";
//	}
//
//	@PostMapping("/adduser")
//	public String procesUser(@ModelAttribute UserTO userto) {
//		try {
//			writerService.insertOne(userto.getFname());
//			return "success";
//		} catch (Exception e) {
//			return "showmessage";
//		}
//
//	}
//	
//	
//	
//	@GetMapping("/updateuser")
//	public String UserUpdateForm(Model model) {
//		model.addAttribute("user", new WriterTO());
//		return "updateuser";
//	}
//
//	@PostMapping("/updateuser")
//	public String processUpdateUser(@ModelAttribute UserTO userto) {
//		try {
//			writerService.insertOne(userto.getFname());
//			return "success";
//		} catch (Exception e) {
//			return "showmessage";
//		}
//
//	}

}
