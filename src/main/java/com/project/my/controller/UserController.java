package com.project.my.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.my.dto.UserDto;
import com.project.my.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService service;
	
	//���̵� �ߺ�üũ
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public String idCheck(Model model, @RequestParam("userId") String userId) throws Exception {
		logger.info("get idCheck");
			
		int result = service.idCheck(userId);
			
		if(result == 1) {	//�ߺ����̵� ����
			model.addAttribute("message", "failure");
		}
		else {
			model.addAttribute("message", "success");
		}
		
		return "registerView";
	}
	
	//ȸ������ ȭ��
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() throws Exception {
		logger.info("get register");
		
		return "registerView";
	}
	
	//ȸ������ ó��
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(UserDto user) throws Exception {
		logger.info("post register");
		
		service.registerUser(user);

		return "login";
			
	}
	
	//�α��� ó��
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, UserDto user, Model model) throws Exception {
		logger.info("post login");
		
		HttpSession httpSession = request.getSession();
		UserDto result = service.login(user);
		
		if(result == null) { //�α��� ����
			logger.info("login failure");
			
			httpSession.setAttribute("userId", null);
			model.addAttribute("message", "failure");
			
			return "redirect:/";
		}
		else {
			logger.info("login successs");
			
			httpSession.setAttribute("userId", result.getUserId());
			model.addAttribute("message", "success");
			
			return "home";
		}
		
	}
	
	//�α׾ƿ� ó��
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) throws Exception {
		logger.info("get logout");
		
		httpSession.invalidate();
		
		return "redirect:/";
	}
	
	//idpwã�� ȭ��
	@RequestMapping(value = "/findIdPw", method = RequestMethod.GET)
	public String findIdPw() throws Exception {
		logger.info("get findIdPw");
		
		return "findIdPwView";
	}
	
	//idã�� ó��
	@RequestMapping(value = "/findId", method = RequestMethod.POST)
	public String findId(@RequestParam HashMap<String, String> param, Model model) throws Exception {
		logger.info("post findId");
		
		String result = service.findId(param);
		
		//null�̸� ���â
		model.addAttribute("id", result);
		
		return "redirect:/";
	}
	
	//pwã�� ó��
	@RequestMapping(value = "/findPw", method = RequestMethod.POST)
	public String findPw(@RequestParam HashMap<String, String> param, Model model) throws Exception {
		logger.info("post findPw");
		
		String result = service.findPw(param);
		
		//null�̸� ���â
		model.addAttribute("pw", result);
		
		return "redirect:/";
	}
}
