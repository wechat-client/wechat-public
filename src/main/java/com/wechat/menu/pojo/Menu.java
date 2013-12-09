package com.wechat.menu.pojo;

import java.util.List;

import com.wechat.common.utils.json.JSONOmitField;

/**
 * 
 * @author sence
 * 顶级menu
 */
public class Menu {
	
	private Integer menuId;
	@JSONOmitField
	private Integer parentId;


	private String name;
	private String type;
	private String url;
	private String key;
	private Integer appId;
	private Integer userId;
	
	private List<Menu> sub_button;
	
	
	public Menu() {
		
	}
	
	
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
	public List<Menu> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<Menu> sub_button) {
		this.sub_button = sub_button;
	}


	public Integer getAppId() {
		return appId;
	}


	public void setAppId(Integer appId) {
		this.appId = appId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getMenuId() {
		return menuId;
	}


	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}


	public Integer getParentId() {
		return parentId;
	}


	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
