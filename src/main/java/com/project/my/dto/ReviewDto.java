package com.project.my.dto;

public class ReviewDto {
	
	private int reviewIdx;
	private String reviewContent;
	private String reviewDate;
	private int reviewCount;
	private String userId;
	private int movieIdx;
	
	public int getReviewIdx() {
		return reviewIdx;
	}
	
	public void setReviewIdx(int reviewIdx) {
		this.reviewIdx = reviewIdx;
	}
	
	public String getReviewContent() {
		return reviewContent;
	}
	
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	
	public String getReviewDate() {
		return reviewDate;
	}
	
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	public int getReviewCount() {
		return reviewCount;
	}
	
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserIdx(String userId) {
		this.userId = userId;
	}
	
	public int getMovieIdx() {
		return movieIdx;
	}
	
	public void setMovieIdx(int movieIdx) {
		this.movieIdx = movieIdx;
	}
	
	@Override
	public String toString() {
		
		return "ReviewDto [reviewIdx=" + reviewIdx + ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate + 
				", reviewCount=" + reviewCount + ", userId=" + userId + ", movieIdx=" + movieIdx + "]";
	}
}
