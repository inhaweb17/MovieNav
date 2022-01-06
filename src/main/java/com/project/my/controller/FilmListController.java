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
	
	// �帣�� ����Ʈ
	@RequestMapping(value = "/genreList", method = RequestMethod.POST)
	public String genreList(@RequestParam("genre") String genre, Model model) throws Exception {
		logger.info("post genreList");
		
		List<FilmDto> result = api.callFilmByGenre(genre);
		
		model.addAttribute("result", result);
		
		//���� ����
		return null;
	}
	
	// �˻��� ����Ʈ
	@RequestMapping(value = "/searchList", method = RequestMethod.POST)
	public String searchList(@RequestParam("title") String title, Model model) throws Exception {
		logger.info("post searchList");
		
		List<FilmDto> result = api.getSearchList(title);
		
		model.addAttribute("result", result);
		
		//���� ����
		return null;
	}
	
	// ����������
	@RequestMapping(value = "/newFilmList", method = RequestMethod.POST)
	public String newFilmList(Model model) throws Exception {
		logger.info("post newFilmList");
		
		List<String> titlelist = api.callNewFilm();
		
		List<FilmDto> filmlist = api.callFilmList(titlelist);
		
		model.addAttribute("filmlist", filmlist);
		
		//���� ����
		return null;
	}
}
