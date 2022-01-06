package com.project.my.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.my.dto.FilmDto;
import com.project.my.util.CallAPI;

@Controller
@RequestMapping("/filmList")
public class FilmListController {
	
	private static final Logger logger = LoggerFactory.getLogger(FilmListController.class);
	
	CallAPI api = new CallAPI();
	
	// 장르별 리스트
	@RequestMapping(value = "/genreList", method = RequestMethod.POST)
	public String genreList(@RequestParam("genre") String genre, Model model) throws Exception {
		logger.info("post genreList");
		
		List<FilmDto> result = api.callFilmByGenre(genre);
		
		model.addAttribute("result", result);
		
		//어디로 갈지
		return null;
	}
	
	// 검색어 리스트
	@RequestMapping(value = "/searchList", method = RequestMethod.POST)
	public String searchList(@RequestParam("title") String title, Model model) throws Exception {
		logger.info("post searchList");
		
		List<FilmDto> result = api.getSearchList(title);
		
		model.addAttribute("result", result);
		
		//어디로 갈지
		return null;
	}
	
	// 개봉예정작
	@RequestMapping(value = "/newFilmList", method = RequestMethod.POST)
	public String newFilmList(Model model) throws Exception {
		logger.info("post newFilmList");
		
		List<String> titlelist = api.callNewFilm();
		
		List<FilmDto> filmlist = api.callFilmList(titlelist);
		
		model.addAttribute("filmlist", filmlist);
		
		//어디로 갈지
		return null;
	}
}
