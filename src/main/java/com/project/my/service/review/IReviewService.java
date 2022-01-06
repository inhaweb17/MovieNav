package com.project.my.service.review;

import java.util.List;

import com.project.my.dto.ReviewDto;

public interface IReviewService {
	//리뷰 등록
	//리뷰 수정 -> 내용, 날자 업데이트
	//좋아요업데이트
	//삭제
	//리뷰상세가져오기
	//영화별 리스트가져오기
	//유저별 리스트가져오기
	//전체 리스트가져오기
	public void registerReview(ReviewDto review) throws Exception;
	public void modifyReview(ReviewDto review) throws Exception;
	public void modifyCount(ReviewDto review) throws Exception;
	public void deleteReview(int reviewIdx) throws Exception;
	public ReviewDto selectReview(int reviewIdx) throws Exception;
	public List<ReviewDto> selectByFilm(int movieIdx) throws Exception;
	public List<ReviewDto> selectByUserId(String userId) throws Exception;
	public List<ReviewDto> selectAll() throws Exception;
}
