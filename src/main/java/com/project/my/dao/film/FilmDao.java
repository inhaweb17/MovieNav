package com.project.my.dao.film;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.my.dto.FilmDto;

@Repository("FilmDao")
public class FilmDao implements IFilmDao {

	private static final String namespace = "com.project.my.FilmMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public FilmDto selectbyIdx(int movieIdx) throws Exception {
		
		return sqlSession.selectOne(namespace + ".selectbyIdx", movieIdx);
	}
	
	@Override
	public FilmDto selectByTitle(String title) throws Exception {
		
		return sqlSession.selectOne(namespace + ".selectByTitle", title);
	}

	@Override
	public void updateGrade(FilmDto film) throws Exception {
		
		sqlSession.update(namespace + ".updateGrade", film);
	}

	@Override
	public void insertFilm(FilmDto film) throws Exception {
		
		sqlSession.insert(namespace + ".insertFilm", film);
	}
	


}
