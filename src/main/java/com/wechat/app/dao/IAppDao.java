package com.wechat.app.dao;

import java.util.List;

import com.wechat.app.pojo.App;

public interface IAppDao {

	List<App> findUserApp(Integer userId);
	
}
