package com.wechat.menu.dao;

import java.util.List;

import com.wechat.menu.pojo.Menu;

public interface IMenuDao {

	List<Menu> getMenuByUser(Integer userID, Integer appID);
	
	void saveMenu();
	
	
}
