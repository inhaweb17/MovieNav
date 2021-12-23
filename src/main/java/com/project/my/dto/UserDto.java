package com.project.my.dto;

public class UserDto {
	
	private String userId;
	private String userName;
	private String userPw;
	private String userEmail;
	private String userNumber;
	private String userBday;
	
	public UserDto() {
		super();
	}
	
	public UserDto(String userId, String userName, String userPw, String userEmail, String userNumber, String userBday) {
		this.userId = userId;
		this.userName = userName;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.userNumber = userNumber;
		this.userBday = userBday;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPw() {
		return userPw;
	}
	
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserNumber() {
		return userNumber;
	}
	
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	
	public String getUserBday() {
		return userBday;
	}
	
	public void setUserBday(String userBday) {
		this.userBday = userBday;
	}
	
	@Override
	public String toString() {
		
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPw=" + userPw + ", userEmail=" + userEmail +
				", userNumber=" + userNumber + ", userBday=" + userBday + "]";
	}
}
