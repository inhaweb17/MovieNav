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

import com.project.my.dto.ReviewDto;
import com.project.my.service.review.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	ReviewService service;
	
	//�����
	@RequestMapping(value = "/reviewDetail", method = RequestMethod.POST)
	public String reviewDetail(@RequestParam("reviewIdx") int reviewIdx, Model model) throws Exception {
		
		ReviewDto result = service.selectReview(reviewIdx);
		
		model.addAttribute("review", result);
		
		//���ΰ��� �ٽ�üũ
		return "redirect:/";
	}
	
	//������� ó��
	@RequestMapping(value = "/modifyReview", method = RequestMethod.POST)
	public String modifyReview(ReviewDto review) throws Exception {
		logger.info("post modifyReview");
		
		service.modifyReview(review);
		
		//���ΰ��� �ٽ�üũ
		return "redirect:/";
	}
	
	//������� ó��
	@RequestMapping(value = "/deleteReview", method = RequestMethod.POST)
	public String deleteReview(HttpSession httpSession, ReviewDto review, Model model) throws Exception {
		logger.info("post deleteReview");
		
		//����
		service.deleteReview(review.getReviewIdx());
		
		//�������Ʈ �ѱ��
		String userId = (String) httpSession.getAttribute("userId");
		
		List<ReviewDto> reviewlist = service.selectByUserId(userId); 
		
		model.addAttribute("reviewlist", reviewlist);	
		
		//���ΰ��� �ٽ�üũ
		return "redirect:/";
	}
	
}
