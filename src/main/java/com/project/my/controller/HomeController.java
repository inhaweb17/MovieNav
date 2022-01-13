package com.project.my.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.my.dto.FilmDto;
import com.project.my.dto.ReviewDto;
import com.project.my.service.review.ReviewService;
import com.project.my.util.CallAPI;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ReviewService reviewService;
	
	CallAPI api = new CallAPI();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("get home");
		
		// �Ϻ� �ڽ����ǽ�
		List<String> boxoffice = api.callBoxOfiice();
		List<FilmDto> filmlist = api.callFilmList(boxoffice);
		
		List<String> poster = new ArrayList<String>();
		
		for(FilmDto film : filmlist) {
			String image = film.getPoster();
			poster.add(image);
		}
		
		model.addAttribute("boxoffice", boxoffice );
		model.addAttribute("poster", poster);
		
		//��ü ���� - �ֽż�
		List<ReviewDto> reviewlist = reviewService.selectAll();
		model.addAttribute("reviewlist", reviewlist);
	
		return "home";
	}
	
	// �α��� ȭ��
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() throws Exception {
		logger.info("get login");
		
		return "loginView";
	}
	
	// ȸ������ ȭ��
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerView() throws Exception {
		logger.info("get register");
			
		return "registerView";
	}
	
	// ���������� ȭ��
	@RequestMapping(value = "/readyMovie", method = RequestMethod.GET)
	public String readyMovie(Model model) throws Exception {
		logger.info("get readyMovie");
		
		List<String> titlelist = api.callNewFilm();
		
		List<FilmDto> filmlist = api.callFilmList(titlelist);
		
		model.addAttribute("filmlist", filmlist);
		
		return "readyMovie";
	}
	
	// �帣������ ȭ��
	@RequestMapping(value = "/genreView", method = RequestMethod.GET)
	public String genreView(Model model) throws Exception {
		logger.info("get genreView");
		
		Map<String,List<FilmDto>> genrelist = api.getGenreList();
		
		for(String genre : genrelist.keySet()) {
			List<FilmDto> result = api.callFilmByGenre(genre);
			genrelist.replace(genre, result);
		}
		
		model.addAttribute("genrelist", genrelist);
		
		return "genreView";
	}
	
<<<<<<< HEAD
	//�ӽ� �׽�Ʈ �ڵ�
	
	//��ȭ�󼼺���
	@RequestMapping(value = "/movieDetailView", method = RequestMethod.GET)
	public String movieDetailView() throws Exception {
		logger.info("get movieDetailView");
		
		return "movieDetailView";
	}
	//����������
	
		@RequestMapping(value = "/myPageView", method = RequestMethod.GET)
		public String myPageView() throws Exception {
			logger.info("get myPageView");
			
			return "myPageView";
		}
=======
	// �˻���� ȭ��
	@RequestMapping(value = "/searchView", method = RequestMethod.GET)
	public String searchView(@RequestParam("search") String search, Model model) throws Exception {
		logger.info("get searchView");
			
		List<FilmDto> searchlist = api.getSearchList(search);
			
		model.addAttribute("searchlist", searchlist);
		
		return "searchView";
	}
>>>>>>> ef40dae8ff698db2ad92dd580543e4fc6324c39f
}
