package com.wechat.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wechat.user.dao.UserDao;
import com.wechat.user.pojo.User;
import com.wechat.user.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Resource(name="userDao")
	private UserDao userDao;

	@Override
	public boolean userLogin(User user) {
		
		User dbUser = userDao.findUserByName(user.getUserLoginName());
		
		if(dbUser!=null && (dbUser.getUserPassword().equals(user.getUserPassword()))){
			return true;
		}
		
		return false;
	}

}
