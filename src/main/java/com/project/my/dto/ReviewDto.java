package com.project.my.dto;

public class ReviewDto {
	
	private int reviewIdx;
	private String reviewContent;
	private String reviewDate;
	private int reviewCount;
	private String r_userId;
	private int r_movieIdx;
	
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
	
	public String getR_userId() {
		return r_userId;
	}

	public void setR_userId(String r_userId) {
		this.r_userId = r_userId;
	}

	public int getR_movieIdx() {
		return r_movieIdx;
	}

	public void setR_movieIdx(int r_movieIdx) {
		this.r_movieIdx = r_movieIdx;
	}

}
