package com.wechat.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wechat.app.dao.IAppDao;
import com.wechat.app.pojo.App;
import com.wechat.app.service.IAppService;

@Service("appService")
public class AppServiceImpl implements IAppService {
	
	@Resource(name="appDao")
	private IAppDao appDao;
	

	@Override
	public List<App> getUserApps(Integer userId) {
	
		return appDao.findUserApp(userId);
	}

}
