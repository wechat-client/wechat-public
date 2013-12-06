package com.wechat.menu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wechat.menu.pojo.Menu;

@Repository("menuDao")
public class MenuDao implements IMenuDao{

	@Autowired   private JdbcTemplate jdbcTemplate;
	
	public List<Menu> getMenuByUser(Integer userID, Integer appID) {
		// TODO Auto-generated method stub
		List<Menu> menus = new ArrayList<Menu>(); 
		String sql = "select menu_id, menu_name, menu_type, menu_url, menu_key_code,parent_id from wechat_menu where app_id = ? and user_id = ?";
		try{
			menus = jdbcTemplate.query(sql,
					 new Object []{userID,appID},
					new RowMapper<Menu>(){
				public Menu mapRow(ResultSet rs, int rowNum)
						throws SQLException {
							Menu menu = new Menu();
					menu.setName(rs.getString("menu_name"));
					menu.setMenuId(rs.getInt("menu_id"));
					menu.setType(rs.getString("menu_type"));
					menu.setUrl(rs.getString("menu_url"));
					menu.setParentId(rs.getInt("parent_id"));
					menu.setKey(rs.getString("menu_key_code"));
					return menu;
					}
				}
			);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return menus;
	}

	@Override
	public void saveMenu() {
		// TODO Auto-generated method stub
		
	}

}
