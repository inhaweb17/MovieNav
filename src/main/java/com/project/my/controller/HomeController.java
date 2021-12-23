package com.project.my.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.my.util.CallAPI;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("get home");
		
		// 일별 박스오피스
		CallAPI api = new CallAPI();
		List<String> boxoffice = api.callBoxOfiice();
		List<String> poster = api.callPosterList(boxoffice);
		
		model.addAttribute("boxoffice", boxoffice );
		model.addAttribute("poster", poster);
		
		//전체 리뷰 - 최신순
		
	
		return "home";
	}
	
	//로그인 화면
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() throws Exception {
		logger.info("get login");
		
		return "loginView";
	}
	
	//회원가입 화면
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerView() throws Exception {
		logger.info("get register");
			
		return "registerView";
	}
	
	//개봉예정작 화면
	@RequestMapping(value = "/readyMovie", method = RequestMethod.GET)
	public String readyMovie() throws Exception {
		logger.info("get readyMovie");
		
		return "readyMovie";
	}
	
	//장르별보기 화면
	@RequestMapping(value = "/genreView", method = RequestMethod.GET)
	public String genreView() throws Exception {
		logger.info("get genreView");
		
		return "genreView";
	}
}
