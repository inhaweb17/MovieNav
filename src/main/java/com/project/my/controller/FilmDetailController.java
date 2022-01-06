package com.project.my.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.my.dto.FilmDto;
import com.project.my.dto.GoodDto;
import com.project.my.dto.ReviewDto;
import com.project.my.service.film.FilmService;
import com.project.my.service.good.GoodService;
import com.project.my.service.review.ReviewService;
import com.project.my.util.CallAPI;

@Controller
@RequestMapping("/filmdetail")
public class FilmDetailController {
	
	private static final Logger logger = LoggerFactory.getLogger(FilmDetailController.class);
	
	@Autowired
	FilmService filmService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	GoodService goodService;
	
	CallAPI api = new CallAPI();
	
	// 영화상세정보 처리
	@RequestMapping(value = "/getDetail", method = RequestMethod.POST)
	public String getDetail(@RequestParam("title") String title, HttpSession httpSession, Model model) throws Exception {
		logger.info("post getfilmDetail");
		
		// db 확인
		FilmDto film = filmService.checkFilm(title);
		
		if(film == null) {	// 없으면 db에 추가
			film = api.callFilmK(title);
			film = api.callFilmN(film);
			
			filmService.registerFilm(film);
		}
		
		model.addAttribute("film", film);
		
		// 어디로 갈지
		return null;
	}
	
	// 영화평점 처리
	@RequestMapping(value = "/filmRating", method = RequestMethod.POST)
	public String filmRating(@RequestParam("rating") int rating, @RequestParam("add") int add, FilmDto film, Model model) throws Exception {
		logger.info("post filmRating");
		
		float averGrade = film.getAverGrade();
		int totalGrade = film.getTotalGrade();
		int userCount = film.getUserCount();
		
		// 평점에 더하는지 여부
		if(add == 0) {
			totalGrade -= rating;
			--userCount;
		}
		else {
			totalGrade += rating;
			++userCount;
		}
		averGrade = (float) totalGrade / userCount;
		
		film.setAverGrade(averGrade);
		film.setTotalGrade(totalGrade);
		film.setUserCount(userCount);
		
		filmService.modifyGrade(film);
		
		model.addAttribute("film", film);
		
		// 어디로 갈지
		return null;
	}
	
	// 영화찜 화면
	@RequestMapping(value = "/filmGood", method = RequestMethod.POST)
	public void filmList(@RequestParam("title") String title, @RequestParam("add") int add, HttpSession httpSession, Model model) throws Exception {
		logger.info("post filmGood");
		
		String userId = (String) httpSession.getAttribute("userId");
		
		GoodDto good = new GoodDto();
		good.setG_userId(userId);
		good.setG_title(title);
		
		GoodDto result = goodService.selectGood(good);
		
		if(result == null) 
			model.addAttribute("result", "True");
		else
			model.addAttribute("result", "False");
		
	}
	
	// 영화찜 처리
	@RequestMapping(value = "/filmGoodAction", method = RequestMethod.POST)
	public void filmGoodAction(@RequestParam("title") String title, @RequestParam("add") int add, HttpSession httpSession) throws Exception {
		logger.info("post filmGoodAction");
		
		String userId = (String) httpSession.getAttribute("userId");
		
		GoodDto good = new GoodDto();
		good.setG_userId(userId);
		good.setG_title(title);
		
		// 추가 및 삭제 여부
		if(add == 0)
			goodService.deleteGood(good);
		else
			goodService.registerGood(good);
		
	}
	
	// 리뷰리스트 처리
	@RequestMapping(value = "/reviewList", method = RequestMethod.POST)
	public void reviewList(@RequestParam("movieIdx") int movieIdx, Model model) throws Exception {
		logger.info("post film reviewList");
		
		List<ReviewDto> reviewlist = reviewService.selectByFilm(movieIdx);
		
		model.addAttribute("reviewlist", reviewlist);
	}
	
	// 리뷰작성 처리
	@RequestMapping(value = "/registerReview", method = RequestMethod.POST)
	public void registerReview(@RequestParam("movieIdx") int movieIdx, ReviewDto review, Model model) throws Exception {
		logger.info("post film registerReview");
		
		// 리뷰등록
		reviewService.registerReview(review);
		
		// 결과리스트 넘기기
		List<ReviewDto> reviewlist = reviewService.selectByFilm(movieIdx);
		
		model.addAttribute("reviewlist", reviewlist);
	}
	
	// 리뷰좋아요 처리
	@RequestMapping(value = "/reviewGood", method = RequestMethod.POST)
	public String reviewGood(ReviewDto review, @RequestParam("add") int add, Model model) throws Exception {
		logger.info("post reviewGood");
		
		int cnt = review.getReviewCount();
		
		// 좋아요 여부
		if(add == 0)	--cnt;
		else 	++cnt;
		
		review.setReviewCount(cnt);
		reviewService.modifyCount(review);
		
		// 어디로 갈지
		return null;
	}
	
}
