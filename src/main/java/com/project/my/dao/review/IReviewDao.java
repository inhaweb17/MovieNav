package com.project.my.dao.review;

import java.util.List;

import com.project.my.dto.ReviewDto;

public interface IReviewDao {
	
	public void insertReview(ReviewDto review) throws Exception;
	public void updateReview(ReviewDto review) throws Exception;
	public void updateCount(ReviewDto review) throws Exception;
	public void deleteReview(int reviewIdx) throws Exception;
	public ReviewDto selectReview(int reviewIdx)throws Exception;
	public List<ReviewDto> selectByFilm(int movieIdx) throws Exception;
	public List<ReviewDto> selectByUserId(String userId) throws Exception;
	public List<ReviewDto> selectAll() throws Exception;
}
