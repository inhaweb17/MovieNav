package com.project.my.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.my.dao.review.ReviewDao;
import com.project.my.dto.ReviewDto;

@Service
public class ReviewService implements IReviewService {
	
	@Autowired
	ReviewDao reviewDao;

	@Override
	public void registerReview(ReviewDto review) throws Exception {
		
		reviewDao.insertReview(review);
	}

	@Override
	public void modifyReview(ReviewDto review) throws Exception {
		
		reviewDao.updateReview(review);
	}

	@Override
	public void modifyCount(ReviewDto review) throws Exception {
		
		reviewDao.updateCount(review);
	}

	@Override
	public void deleteReview(int reviewIdx) throws Exception {
		
		reviewDao.deleteReview(reviewIdx);
	}

	@Override
	public ReviewDto selectReview(int reviewIdx) throws Exception {
		
		return reviewDao.selectReview(reviewIdx);
	}

	@Override
	public List<ReviewDto> selectByFilm(int movieIdx) throws Exception {
		
		
		return reviewDao.selectByFilm(movieIdx);
	}

	@Override
	public List<ReviewDto> selectByUserId(String userId) throws Exception {
		
		
		return reviewDao.selectByUserId(userId);
	}

	@Override
	public List<ReviewDto> selectAll() throws Exception {
		
		
		return reviewDao.selectAll();
	}

}
