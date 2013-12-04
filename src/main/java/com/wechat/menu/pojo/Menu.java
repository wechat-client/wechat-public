package com.wechat.menu.pojo;

/**
 * 
 * @author sence
 * 顶级menu
 */
public class Menu {
	
	private String name;
	private String type;
	private String url;
	private String key;
	
	private Menu[] sub_button;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public Menu[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(Menu[] sub_button) {
		this.sub_button = sub_button;
	}
	

}
