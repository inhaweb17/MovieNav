package com.project.my.dao.user;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.my.dto.UserDto;

@Repository("UserDao")
public class UserDao implements IUserDao {
	
	private static final String namespace = "com.project.my.UserMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertUser(UserDto user) throws Exception {
		
		sqlSession.insert(namespace + ".insertUser", user);
	}

	@Override
	public UserDto selectById(String userId) throws Exception {
		
		return sqlSession.selectOne(namespace + ".selectById", userId);
	}
	
	@Override
	public UserDto login(UserDto user) throws Exception {
		
		return sqlSession.selectOne(namespace + ".login", user);
	}
	
	@Override
	public String selectByNameNum(HashMap<String, String> param) throws Exception {
		
		return sqlSession.selectOne(namespace + ".selectByNameNum", param);
	}
	
	@Override
	public String selectByIdNum(HashMap<String, String> param) throws Exception {
		
		return sqlSession.selectOne(namespace + ".selectByIdNum", param);
	}
	
	@Override
	public void updateUser(UserDto user) throws Exception {
		
		sqlSession.update(namespace + ".updateUser", user);
	}
	
	@Override
	public void updateUserPw(UserDto user) throws Exception {
		
		sqlSession.update(namespace + ".updateUserPw", user);
	}
}
