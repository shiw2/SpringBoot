package com.demo.vo;

public class UserReq {
	private String userName;
	private String userSex;
	private String userBirthday;
	private String userEmail;

	public UserReq(String userName, String userSex, String userBirthday, String userEmail) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}