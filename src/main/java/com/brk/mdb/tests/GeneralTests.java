package com.brk.mdb.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.brk.mdb.modelsTO.ActorTO;
import com.brk.mdb.modelsTO.AwardTO;
import com.brk.mdb.modelsTO.DirectorTO;
import com.brk.mdb.modelsTO.FeedbackTO;
import com.brk.mdb.modelsTO.GenreTO;
import com.brk.mdb.modelsTO.LanguageTO;
import com.brk.mdb.modelsTO.MovieReviewTO;
import com.brk.mdb.modelsTO.MovieTO;
import com.brk.mdb.modelsTO.ProductionTO;
import com.brk.mdb.modelsTO.UserTO;
import com.brk.mdb.modelsTO.WriterTO;

public class GeneralTests {

	public static void bulkInsert(UserService uS, MovieService mvS, ActorService actS, AwardService awdS,
			DirectorService dS, FeedbackService fS, GenreService gS, LanguageService lS, ProductionService pS,
			WriterService wS) throws ParseException {

		Date dt1 = new SimpleDateFormat("yyyy/MM/dd").parse("1980/5/18");
		Date dt2 = new SimpleDateFormat("yyyy/MM/dd").parse("1998/11/27");
		Date dt3 = new SimpleDateFormat("yyyy/MM/dd").parse("1990/1/9");
		Date dt4 = new SimpleDateFormat("yyyy/MM/dd").parse("1980/4/15");
		Date dt5 = new SimpleDateFormat("yyyy/MM/dd").parse("1995/10/20");
		Date dt6 = new SimpleDateFormat("yyyy/MM/dd").parse("1950/12/18");
		Date dt7 = new SimpleDateFormat("yyyy/MM/dd").parse("1970/9/3");
		Date dt8 = new SimpleDateFormat("yyyy/MM/dd").parse("1972/6/7");
		Date dt9 = new SimpleDateFormat("yyyy/MM/dd").parse("2000/5/12");
		Date dt10 = new SimpleDateFormat("yyyy/MM/dd").parse("2010/2/16");

		// movie insert
		MovieTO mov1 = mvS.insertOne("The Titanic", 128, 18200000000L, 2468300000000L, "PG-13", "story 1", dt1);
		MovieTO mov2 = mvS.insertOne("Matrix", 115, 1820000000L, 24683000000L, "NC-17", "story 2", dt2);
		MovieTO mov3 = mvS.insertOne("Welcome to Jungle", 132, 175000000L, 246830000000L, "R", "story 3", dt3);
		MovieTO mov4 = mvS.insertOne("Harry Potter", 168, 182000000L, 2468300000L, "PG-13", "story 4", dt4);
		MovieTO mov5 = mvS.insertOne("The Grudge", 129, 1898000000L, 24683000000L, "R", "story 5", dt5);
		MovieTO mov6 = mvS.insertOne("Back to The Future", 121, 18200000000L, 2468300000L, "PG-13", "story 6", dt6);
		MovieTO mov7 = mvS.insertOne("Max Max Fury Road", 113, 18200000000L, 2468300000000L, "PG-13", "story 7", dt7);
		MovieTO mov8 = mvS.insertOne("London has fallen", 222, 182000000L, 2468300000L, "R", "story 8", dt8);
		MovieTO mov9 = mvS.insertOne("Autopsy of Jane Doe", 172, 182000000L, 2468300000000L, "NC-17", "story 9", dt9);
		MovieTO mov10 = mvS.insertOne("High School", 150, 1820000L, 246830000L, "PG-13", "story 10", dt10);

		// add users
		UserTO usr1 = uS.insertOne("Savan", "Hapani", "sh@mail.com", 1231231231L, dt1, "Ahmedabad", "Gujarat", "India");
		UserTO usr2 = uS.insertOne("Taher", "Mandapvala", "sh@mail.com", 6789067890L, dt2, "Bharuch", "Gujarat",
				"India");
		UserTO usr3 = uS.insertOne("Parth", "Mangukiya", "pm@mail.com", 1234512345L, dt3, "Surat", "Gujarat", "India");
		UserTO usr4 = uS.insertOne("Keval", "Mehta", "km@mail.com", 9876543210L, dt4, "Rajkot", "Gujarat", "India");
		UserTO usr5 = uS.insertOne("Riya", "Sharma", "rs@mail.com", 5675675675L, dt5, "Surat", "Gujarat", "India");

		// add reviews
		mvS.addReview(mov1.getId(), usr1.getId(), 8, "Amazing movie");
		mvS.addReview(mov1.getId(), usr2.getId(), 4, "not good");
		mvS.addReview(mov1.getId(), usr3.getId(), 1, "time waste");
		mvS.addReview(mov1.getId(), usr4.getId(), 7, "complicated to understand");
		mvS.addReview(mov2.getId(), usr1.getId(), 10, "very emotional");
		mvS.addReview(mov2.getId(), usr2.getId(), 6, "light weight");
		mvS.addReview(mov3.getId(), usr1.getId(), 1, "time waste");
		mvS.addReview(mov3.getId(), usr5.getId(), 7, "complicated to understand");
		mvS.addReview(mov3.getId(), usr4.getId(), 8, "nice my kid liked it");
		mvS.addReview(mov4.getId(), usr5.getId(), 0, "it's total waste of money and time");
		mvS.addReview(mov5.getId(), usr1.getId(), 3, "complicated to understand");
		mvS.addReview(mov5.getId(), usr2.getId(), 8, "nice to watch with friends");

		// feedbacks
		FeedbackTO fb1 = fS.insertOne(usr1.getId(), "Very useful system.");
		FeedbackTO fb2 = fS.insertOne(usr2.getId(), "I found a bug.");
		FeedbackTO fb3 = fS.insertOne(usr3.getId(), "Amazing system.");

		// add wish list
		uS.addToWishlist(usr1.getId(), mov1.getId());
		uS.addToWishlist(usr1.getId(), mov2.getId());
		uS.addToWishlist(usr1.getId(), mov3.getId());
		uS.addToWishlist(usr2.getId(), mov1.getId());

		// add actors
		ActorTO act1 = actS.insertOne("Leonardo DiCaprio", dt1, 183, "Jamjodhpur", "Gujarat", "India");
		ActorTO act2 = actS.insertOne("Tom Hanks", dt2, 172, "Diu", "Gujarat", "India");
		ActorTO act3 = actS.insertOne("Brad Pitt", dt3, 170, "Bhuj", "Gujarat", "India");
		ActorTO act4 = actS.insertOne("Johnny Depp", dt4, 194, "Ahmedabad", "Gujarat", "India");
		ActorTO act5 = actS.insertOne("Tom Cruise", dt5, 169, "Surat", "Gujarat", "India");
		ActorTO act6 = actS.insertOne("Dwayne Johnson", dt6, 174, "Jamnagar", "Gujarat", "India");
		ActorTO act7 = actS.insertOne("Jennifer Lawrence", dt7, 165, "Morbi", "Gujarat", "India");
		ActorTO act8 = actS.insertOne("Angelina Jolie", dt8, 180, "Ghatila", "Gujarat", "India");
		ActorTO act9 = actS.insertOne("Scarlett Johansson", dt9, 176, "Lalpar", "Gujarat", "India");
		ActorTO act10 = actS.insertOne("Bradley Cooper", dt10, 177, "Jodiya", "Gujarat", "India");

		mvS.addActor(mov1.getId(), act1.getId());
		mvS.addActor(mov1.getId(), act2.getId());
		mvS.addActor(mov1.getId(), act3.getId());
		mvS.addActor(mov2.getId(), act4.getId());
		mvS.addActor(mov2.getId(), act5.getId());
		mvS.addActor(mov2.getId(), act6.getId());
		mvS.addActor(mov3.getId(), act1.getId());
		mvS.addActor(mov3.getId(), act2.getId());
		mvS.addActor(mov3.getId(), act3.getId());
		mvS.addActor(mov3.getId(), act4.getId());
		mvS.addActor(mov4.getId(), act4.getId());
		mvS.addActor(mov4.getId(), act5.getId());
		mvS.addActor(mov4.getId(), act6.getId());
		mvS.addActor(mov5.getId(), act6.getId());
		mvS.addActor(mov6.getId(), act6.getId());
		mvS.addActor(mov7.getId(), act7.getId());
		mvS.addActor(mov8.getId(), act7.getId());
		mvS.addActor(mov9.getId(), act2.getId());
		mvS.addActor(mov10.getId(), act3.getId());

		// add director
		DirectorTO dir1 = dS.insertOne("Steven Spielberg");
		DirectorTO dir2 = dS.insertOne("James Cameron");
		DirectorTO dir3 = dS.insertOne("Martin Scorsese");
		DirectorTO dir4 = dS.insertOne("Stanley Kubrick");
		DirectorTO dir5 = dS.insertOne("Quentin Tarantino");

		mvS.setDirector(mov1.getId(), dir1.getId());
		mvS.setDirector(mov2.getId(), dir2.getId());
		mvS.setDirector(mov3.getId(), dir3.getId());
		mvS.setDirector(mov4.getId(), dir4.getId());
		mvS.setDirector(mov5.getId(), dir5.getId());
		mvS.setDirector(mov6.getId(), dir1.getId());
		mvS.setDirector(mov7.getId(), dir1.getId());
		mvS.setDirector(mov8.getId(), dir2.getId());
		mvS.setDirector(mov9.getId(), dir2.getId());
		mvS.setDirector(mov10.getId(), dir3.getId());

		// add writer
		WriterTO wr1 = wS.insertOne("Woody Allen");
		WriterTO wr2 = wS.insertOne("Charlie Kaufman");
		WriterTO wr3 = wS.insertOne("Stephen King");
		WriterTO wr4 = wS.insertOne("Christopher Nolan");
		WriterTO wr5 = wS.insertOne("Robert Townew");

		mvS.addWriter(mov1.getId(), wr1.getId());
		mvS.addWriter(mov2.getId(), wr1.getId());
		mvS.addWriter(mov3.getId(), wr3.getId());
		mvS.addWriter(mov4.getId(), wr5.getId());
		mvS.addWriter(mov5.getId(), wr3.getId());
		mvS.addWriter(mov6.getId(), wr3.getId());
		mvS.addWriter(mov7.getId(), wr5.getId());
		mvS.addWriter(mov8.getId(), wr4.getId());
		mvS.addWriter(mov9.getId(), wr5.getId());
		mvS.addWriter(mov10.getId(), wr4.getId());

		// add genre
		GenreTO gen1 = gS.insertOne("Sci-Fi");
		GenreTO gen2 = gS.insertOne("Horror");
		GenreTO gen3 = gS.insertOne("Thriller");
		GenreTO gen4 = gS.insertOne("Comedy");
		GenreTO gen5 = gS.insertOne("Mystery");

		mvS.addGenre(mov1.getId(), gen1.getId());
		mvS.addGenre(mov1.getId(), gen2.getId());
		mvS.addGenre(mov2.getId(), gen3.getId());
		mvS.addGenre(mov3.getId(), gen4.getId());
		mvS.addGenre(mov3.getId(), gen5.getId());
		mvS.addGenre(mov4.getId(), gen1.getId());
		mvS.addGenre(mov5.getId(), gen2.getId());
		mvS.addGenre(mov5.getId(), gen3.getId());
		mvS.addGenre(mov6.getId(), gen1.getId());
		mvS.addGenre(mov7.getId(), gen3.getId());
		mvS.addGenre(mov8.getId(), gen4.getId());
		mvS.addGenre(mov9.getId(), gen5.getId());
		mvS.addGenre(mov10.getId(), gen1.getId());

		// add language
		LanguageTO lang1 = lS.insertOne("ENG");
		LanguageTO lang2 = lS.insertOne("GUJ");
		LanguageTO lang3 = lS.insertOne("RUS");
		LanguageTO lang4 = lS.insertOne("JAP");

		mvS.addLanguage(mov1.getId(), lang1.getId());
		mvS.addLanguage(mov1.getId(), lang2.getId());
		mvS.addLanguage(mov1.getId(), lang3.getId());
		mvS.addLanguage(mov2.getId(), lang1.getId());
		mvS.addLanguage(mov2.getId(), lang3.getId());
		mvS.addLanguage(mov3.getId(), lang1.getId());
		mvS.addLanguage(mov4.getId(), lang3.getId());
		mvS.addLanguage(mov5.getId(), lang2.getId());
		mvS.addLanguage(mov6.getId(), lang4.getId());
		mvS.addLanguage(mov7.getId(), lang4.getId());
		mvS.addLanguage(mov8.getId(), lang1.getId());
		mvS.addLanguage(mov9.getId(), lang3.getId());
		mvS.addLanguage(mov10.getId(), lang2.getId());

		// add awards
		AwardTO awd1 = awdS.insertOne("Oscar");
		AwardTO awd2 = awdS.insertOne("Film of the Year");
		AwardTO awd3 = awdS.insertOne("Palme d’or");
		AwardTO awd4 = awdS.insertOne("Bafta");

		mvS.addAward(mov1.getId(), awd1.getId(), dt1);
		mvS.addAward(mov1.getId(), awd2.getId(), dt2);
		mvS.addAward(mov2.getId(), awd3.getId(), dt3);
		mvS.addAward(mov3.getId(), awd4.getId(), dt4);

		// set production
		ProductionTO prod1 = pS.insertOne("20th Century Fox");
		ProductionTO prod2 = pS.insertOne("Paramount Pictures");
		ProductionTO prod3 = pS.insertOne("Universal Pictures");
		ProductionTO prod4 = pS.insertOne("Columbia Pictures");
		ProductionTO prod5 = pS.insertOne("The Walt Disney Company");
		ProductionTO prod6 = pS.insertOne("Sony Pictures");
		ProductionTO prod7 = pS.insertOne("DreamWorks Pictures");
		ProductionTO prod8 = pS.insertOne("Pixar");

		mvS.setProduction(mov1.getId(), prod1.getId());
		mvS.setProduction(mov2.getId(), prod1.getId());
		mvS.setProduction(mov3.getId(), prod1.getId());
		mvS.setProduction(mov4.getId(), prod2.getId());
		mvS.setProduction(mov5.getId(), prod2.getId());
		mvS.setProduction(mov6.getId(), prod3.getId());
		mvS.setProduction(mov7.getId(), prod4.getId());
		mvS.setProduction(mov8.getId(), prod1.getId());
		mvS.setProduction(mov9.getId(), prod2.getId());
		mvS.setProduction(mov10.getId(), prod3.getId());

//		List<ActorTO> mto = mvS.getActors(mov1.getId());
//
//		for (ActorTO aTO : mto) {
//			System.out.println(aTO);
//		}

		// print all things
//		
//		List<MovieTO> movies = uS.getWishlist(usr1.getId());
//		
//		for (MovieTO mto : movies) {
//			System.out.println("\n\n\n\n------------------------------------------------------");
//			System.out.println(mto);
//			System.out.println("----------Actors----------");
//			for (ActorTO x : mvS.getActors(mto.getId())) {
//				System.out.println(x);
//			}
//			System.out.println("----------Genres----------");
//			for (GenreTO x : mvS.getGenres(mto.getId())) {
//				System.out.println(x);
//			}
//			System.out.println("----------Writers----------");
//			for (WriterTO x : mvS.getWriters(mto.getId())) {
//				System.out.println(x);
//			}
//			System.out.println("----------Languages----------");
//			for (LanguageTO x : mvS.getLanguages(mto.getId())) {
//				System.out.println(x);
//			}
//			System.out.println("----------Reviews----------");
//			for (MovieReviewTO x : mvS.getReviews(mto.getId())) {
//				System.out.println(x);
//			}
//			System.out.println("----------Awards----------");
//			for (AwardTO x : mvS.getAwards(mto.getId())) {
//				System.out.println(x);
//			}
//			System.out.println("----------Wishlisted By----------");
//			for (UserTO x : mvS.getWishListedBy(mto.getId())) {
//				System.out.println(x);
//			}
//		}

	}
}
