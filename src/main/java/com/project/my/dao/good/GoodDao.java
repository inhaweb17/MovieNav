package com.project.my.dao.good;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.my.dto.GoodDto;

@Repository
public class GoodDao implements IGoodDao {
	
	private static final String namespace = "com.project.my.GoodMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<String> selectByUserId(String g_userId) throws Exception {

		return sqlSession.selectList(namespace + ".selectByUserId", g_userId);
	}

	@Override
	public void insertGood(GoodDto good) throws Exception {
		
		sqlSession.insert(namespace + ".insertGood", good);
	}

	@Override
	public void deleteGood(GoodDto good) throws Exception {
		
		sqlSession.delete(namespace + ".deleteGood", good);
	}

	@Override
	public GoodDto selectGood(GoodDto good) throws Exception {
		
		return sqlSession.selectOne(namespace + ".selectGood", good);
	}

}
