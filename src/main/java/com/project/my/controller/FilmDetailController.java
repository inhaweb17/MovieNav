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
	
	// ��ȭ������ ó��
	@RequestMapping(value = "/getDetail", method = RequestMethod.POST)
	public String getDetail(@RequestParam("title") String title, HttpSession httpSession, Model model) throws Exception {
		logger.info("post getfilmDetail");
		
		// db Ȯ��
		FilmDto film = filmService.checkFilm(title);
		
		if(film == null) {	// ������ db�� �߰�
			film = api.callFilmK(title);
			film = api.callFilmN(film);
			
			filmService.registerFilm(film);
		}
		
		model.addAttribute("film", film);
		
		// ���� ����
		return null;
	}
	
	// ��ȭ���� ó��
	@RequestMapping(value = "/filmRating", method = RequestMethod.POST)
	public String filmRating(@RequestParam("rating") int rating, @RequestParam("add") int add, FilmDto film, Model model) throws Exception {
		logger.info("post filmRating");
		
		float averGrade = film.getAverGrade();
		int totalGrade = film.getTotalGrade();
		int userCount = film.getUserCount();
		
		// ������ ���ϴ��� ����
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
		
		// ���� ����
		return null;
	}
	
	// ��ȭ�� ȭ��
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
	
	// ��ȭ�� ó��
	@RequestMapping(value = "/filmGoodAction", method = RequestMethod.POST)
	public void filmGoodAction(@RequestParam("title") String title, @RequestParam("add") int add, HttpSession httpSession) throws Exception {
		logger.info("post filmGoodAction");
		
		String userId = (String) httpSession.getAttribute("userId");
		
		GoodDto good = new GoodDto();
		good.setG_userId(userId);
		good.setG_title(title);
		
		// �߰� �� ���� ����
		if(add == 0)
			goodService.deleteGood(good);
		else
			goodService.registerGood(good);
		
	}
	
	// ���丮��Ʈ ó��
	@RequestMapping(value = "/reviewList", method = RequestMethod.POST)
	public void reviewList(@RequestParam("movieIdx") int movieIdx, Model model) throws Exception {
		logger.info("post film reviewList");
		
		List<ReviewDto> reviewlist = reviewService.selectByFilm(movieIdx);
		
		model.addAttribute("reviewlist", reviewlist);
	}
	
	// �����ۼ� ó��
	@RequestMapping(value = "/registerReview", method = RequestMethod.POST)
	public void registerReview(@RequestParam("movieIdx") int movieIdx, ReviewDto review, Model model) throws Exception {
		logger.info("post film registerReview");
		
		// ������
		reviewService.registerReview(review);
		
		// �������Ʈ �ѱ��
		List<ReviewDto> reviewlist = reviewService.selectByFilm(movieIdx);
		
		model.addAttribute("reviewlist", reviewlist);
	}
	
	// �������ƿ� ó��
	@RequestMapping(value = "/reviewGood", method = RequestMethod.POST)
	public String reviewGood(ReviewDto review, @RequestParam("add") int add, Model model) throws Exception {
		logger.info("post reviewGood");
		
		int cnt = review.getReviewCount();
		
		// ���ƿ� ����
		if(add == 0)	--cnt;
		else 	++cnt;
		
		review.setReviewCount(cnt);
		reviewService.modifyCount(review);
		
		// ���� ����
		return null;
	}
	
}
