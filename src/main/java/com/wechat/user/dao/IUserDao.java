package com.wechat.user.dao;

import com.wechat.user.pojo.User;

public interface IUserDao {
	
	User findUserByName(String userName);

}
