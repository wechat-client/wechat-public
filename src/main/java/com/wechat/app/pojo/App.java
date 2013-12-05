package com.wechat.app.pojo;

import java.io.Serializable;

public class App implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6979866318112392037L;
	
	private Integer appId;
	private String appKey;
	private String appSecret;
	
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	
	
	
}
