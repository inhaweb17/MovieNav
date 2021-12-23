package com.project.my.service.user;

import java.util.HashMap;

import com.project.my.dto.UserDto;

public interface IUserService {
	
	public void registerUser(UserDto user) throws Exception;
	public int idCheck(String userId) throws Exception;
	public UserDto login(UserDto user) throws Exception;
	public String findId(HashMap<String, String> param) throws Exception;
	public String findPw(HashMap<String, String> param) throws Exception;
	public void modifyUser(UserDto user) throws Exception;
	public UserDto selectUser(String userId) throws Exception;
	public void modifyUserPw(UserDto user) throws Exception;
}
