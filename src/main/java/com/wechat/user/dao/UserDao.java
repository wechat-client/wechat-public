package com.wechat.user.dao;

import com.wechat.user.pojo.User;

public interface UserDao {
	
	User findUserByName(String userName);

}
