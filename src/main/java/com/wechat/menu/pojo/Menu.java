package com.wechat.menu.pojo;

import com.wechat.pojo.MenuBasic;

public class Menu extends MenuBasic{
	private String type;  
    private String url;  
    private String key;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}  
    
    
}
