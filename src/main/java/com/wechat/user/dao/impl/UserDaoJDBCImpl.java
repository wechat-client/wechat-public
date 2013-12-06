package com.wechat.user.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.wechat.user.dao.IUserDao;
import com.wechat.user.pojo.User;

@Repository("userDao")
public class UserDaoJDBCImpl implements IUserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User findUserByName(String userName) {
		
		User user =null;
		try {
			user = jdbcTemplate.queryForObject("select user_id,user_login_name,user_password from wechat_user where user_login_name = ?", 
				new Object[]{userName},
				new RowMapper<User>(){
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setUserLoginName(rs.getString("user_login_name"));
						user.setUserId(rs.getInt("user_id"));
						user.setUserPassword(rs.getString("user_password"));
						return user;
					}
				}
			);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
}
