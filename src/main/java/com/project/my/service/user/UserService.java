package com.project.my.service.user;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.my.dao.user.UserDao;
import com.project.my.dto.UserDto;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public void registerUser(UserDto user) throws Exception {
		
		userDao.insertUser(user);
	}

	@Override
	public int idCheck(String userId) throws Exception {
		
		if(userDao.selectById(userId) == null) 
			return 0;
		else
			return 1;
	}
	
	@Override
	public UserDto login(UserDto user) throws Exception {
		
		return userDao.login(user);
	}
	
	@Override
	public String findId(HashMap<String, String> param) throws Exception {
		
		return userDao.selectByNameNum(param);
	}
	
	@Override
	public String findPw(HashMap<String, String> param) throws Exception {
		
		return userDao.selectByIdNum(param);
	}
	
	@Override
	public void modifyUser(UserDto user) throws Exception {
		
		userDao.updateUser(user);
	}
	
	@Override
	public UserDto selectUser(String userId) throws Exception {
		
		return userDao.selectById(userId);
	}
	
	@Override
	public void modifyUserPw(UserDto user) throws Exception {
		
		userDao.updateUserPw(user);
	}
}
