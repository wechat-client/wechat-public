package com.wechat.user.pojo;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1426050214527663033L;
	
	private Integer userId;
	private String userPassword;
	private String userLoginName;
	private String userTrueName;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserLoginName() {
		return userLoginName;
	}
	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	public String getUserTrueName() {
		return userTrueName;
	}
	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}
	
	
}
