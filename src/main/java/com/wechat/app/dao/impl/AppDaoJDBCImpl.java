package com.wechat.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wechat.app.dao.IAppDao;
import com.wechat.app.pojo.App;

@Repository("appDao")
public class AppDaoJDBCImpl implements IAppDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<App> findUserApp(Integer userId) {
		
		
		
		String sql = "select wa.app_id,wa.app_key,wa.app_secret "
				+ "from wechat_user wu LEFT JOIN wechat_user_app wua ON wu.user_id = wua.user_id "
				+ "LEFT JOIN wechat_app wa ON wua.app_id = wa.app_id "
				+ "WHERE wu.user_id = ?";
		
	
		List<App> apps = jdbcTemplate.query(sql, new Object[]{userId}, new RowMapper<App>(){

			public App mapRow(ResultSet rs, int rowNum) throws SQLException {
					App app = new App();
					app.setAppId(rs.getInt("app_id"));
					app.setAppKey(rs.getString("app_key"));
					app.setAppSecret(rs.getString("app_secret"));
					return app;
			}
			
		});
		
		return apps;
		
	}

	
	
}
