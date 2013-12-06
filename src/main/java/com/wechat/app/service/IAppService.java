package com.wechat.app.service;

import java.util.List;

import com.wechat.app.pojo.App;

public interface IAppService {
	
	List<App> getUserApps(Integer userId);

}
