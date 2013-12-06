package com.wechat.menu.service;

import java.util.List;

import com.wechat.app.pojo.App;
import com.wechat.menu.pojo.Menu;
import com.wechat.user.pojo.User;

public interface IMenuService {
	
	List<Menu>   getMenu(User user, App app);

}
