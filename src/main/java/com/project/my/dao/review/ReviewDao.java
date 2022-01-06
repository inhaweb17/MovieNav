package com.project.my.dao.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.my.dto.ReviewDto;

@Repository
public class ReviewDao implements IReviewDao {
	
	private static final String namespace = "com.project.my.ReviewMapper";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertReview(ReviewDto review) throws Exception {
		
		sqlSession.insert(namespace + ".insertReview", review);
	}

	@Override
	public void updateReview(ReviewDto review) throws Exception {
		
		sqlSession.update(namespace + ".updateReview", review);
	}

	@Override
	public void updateCount(ReviewDto review) throws Exception {
		
		sqlSession.update(namespace + ".updateCount", review);
	}

	@Override
	public void deleteReview(int reviewIdx) throws Exception {
		
		sqlSession.delete(namespace + ".deleteReview", reviewIdx);
	}

	@Override
	public ReviewDto selectReview(int reviewIdx) throws Exception {

		
		return sqlSession.selectOne(namespace + ".selectReview", reviewIdx);
	}

	@Override
	public List<ReviewDto> selectByFilm(int r_movieIdx) throws Exception {

		return sqlSession.selectList(namespace + ".selectByFilm", r_movieIdx);
	}

	@Override
	public List<ReviewDto> selectByUserId(String r_userId) throws Exception {

		return sqlSession.selectList(namespace + ".selectByUserId", r_userId);
	}

	@Override
	public List<ReviewDto> selectAll() throws Exception {

		return sqlSession.selectList(namespace + ".selectAll");
	}

}
