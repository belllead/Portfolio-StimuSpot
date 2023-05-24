package com.ssafy.pjt.model.dto;

public class UserDto {
	private int userNum;
	private String userId;
	private String userPw;
	private String userName;
	private String userNickname;
	private String userEmail;
	private int userAge;
	private String userSelfie;
	
	public UserDto() {
	}

	public UserDto(int userNum, String userId, String userPw, String userName, String userNickname, String userEmail, int userAge,
			String userSelfie) {
		super();
		this.userNum = userNum;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userAge = userAge;
		this.userSelfie = userSelfie;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserSelfie() {
		return userSelfie;
	}

	public void setUserSelfie(String userSelfie) {
		this.userSelfie = userSelfie;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
  
	@Override
	public String toString() {
		return "UserDto [userNum=" + userNum + ", userId=" + userId + ", userPw=" + userPw + ", userNickname="
				+ userNickname + ", userEmail=" + userEmail + ", userAge=" + userAge + ", userSelfie=" + userSelfie
				+ "]";
	}
	
	
}
