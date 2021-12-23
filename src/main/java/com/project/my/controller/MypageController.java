package com.project.my.controller;

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
@RequestMapping("/mypage")
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	//myinfo 화면
	@RequestMapping(value = "/myinfo", method = RequestMethod.POST)
	public String myinfo(HttpSession httpSession, Model model) throws Exception {
		logger.info("post myinfo");
		
		String userId = (String) httpSession.getAttribute("userId");
		UserDto user = userService.selectUser(userId);
		
		model.addAttribute("user", user);
		
		return "myinfo";
	}
	
	//myinfo수정 화면
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modify() throws Exception {
		logger.info("get modify");
	}
	
	//myinfo수정 처리
	@RequestMapping(value = "/modify", method = RequestMethod.POST) 
	public String modify(HttpSession httpSession, UserDto user) throws Exception {
		logger.info("post modify");
		
		String userId = (String) httpSession.getAttribute("userId");
		user.setUserId(userId);
		
		userService.modifyUser(user);
		
		return "myinfo";
	}
	
	//pw수정 화면
	@RequestMapping(value = "/modifyPw", method = RequestMethod.GET)
	public void modifyPw() throws Exception {
		logger.info("get modifyPw");
	}
	
	//pw수정 처리
	@RequestMapping(value = "/modifyPw", method = RequestMethod.POST)
	public String modifyPw(@RequestParam("pw") String pw, @RequestParam("newpw") String newpw, HttpSession  httpSession, Model model) throws Exception {
		logger.info("post modfiyPw");
		
		String userId = (String) httpSession.getAttribute("userId");
		UserDto user = userService.selectUser(userId);
		
		String userPw = user.getUserPw();
		if(!userPw.equals(pw)) {	//현재 비밀번호와 불일치
			logger.info("modifyPw failure");
			
			model.addAttribute("message", "failure");
		}
		else {	//현재 비밀번호와 일치
			logger.info("modifyPw success");
			
			//비밀번호 변경
			user.setUserPw(newpw);
			userService.modifyUserPw(user);
			
			model.addAttribute("message", "success");
		}
		
		return "redirect:/";
		
	}
}
