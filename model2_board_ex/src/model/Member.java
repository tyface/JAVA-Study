package model;

import java.sql.Date;

public class Member {

	private int userIdx;
	private String userId;
	private String userPw;
	private String userName;
	private String email;
	private Date userRegDate;
	private String profile;

	
	
	public Member() {
		this.userIdx = 0;
		this.userId = null;
		this.userPw = null;
		this.userName = null;
		this.email = null;
		this.userRegDate = null;
		this.profile = null;
	}

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getUserRegDate() {
		return userRegDate;
	}

	public void setUserRegDate(Date userRegDate) {
		this.userRegDate = userRegDate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Member [userIdx=" + userIdx + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", email=" + email + ", userRegDate=" + userRegDate + ", profile=" + profile + "]";
	}


}
