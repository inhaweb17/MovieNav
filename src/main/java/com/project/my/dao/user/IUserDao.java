package com.project.my.dao.user;

import java.util.HashMap;

import com.project.my.dto.UserDto;

public interface IUserDao {

	public void insertUser(UserDto user) throws Exception;
	public UserDto selectById(String userId) throws Exception;
	public UserDto login(UserDto user) throws Exception;
	public String selectByNameNum(HashMap<String, String> param) throws Exception;
	public String selectByIdNum(HashMap<String, String> param) throws Exception;
	public void updateUser(UserDto user) throws Exception;
	public void updateUserPw(UserDto user) throws Exception;
}
