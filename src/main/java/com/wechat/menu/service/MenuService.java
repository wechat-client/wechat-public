package com.wechat.menu.service;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.wechat.common.utils.ConnectWechatUtil;
import com.wechat.common.utils.MenuUtil;
import com.wechat.menu.pojo.Menu;

@Service
public class MenuService {
		
	/** 
     * 创建菜单 
     *  
     * @param menu 菜单实例 
     * @param accessToken 有效的access_token 
     * @return 0表示成功，其他值表示失败 
     */  
    public  void createMenu(List<Menu> menus) {  
       
        
        
}


/** 
 * 组装菜单数据 
 * @return 
 */  
public static List<Menu> getMenu() {  
	
	List<Menu> menus = new ArrayList<Menu>();
	//第一个一级菜单
  	Menu pM_1 = new Menu();
  	pM_1.setName("非姐养生");
  	
  	
  	//第一个一级菜单的子菜单
  	Menu pM_1_sub_1 = new Menu();
  	pM_1_sub_1.setName("非姐淘宝小铺");
	pM_1_sub_1.setType(MenuUtil.MENU_TYPE_VIEW);
	pM_1_sub_1.setUrl("https://shop106322402.m.taobao.com/");
	
	Menu pM_1_sub_2 = new Menu();
	pM_1_sub_2.setName("非姐V付");
	pM_1_sub_2.setType(MenuUtil.MENU_TYPE_CLICK);
	pM_1_sub_2.setKey(MenuUtil.KEY_V_PAY);
	
	//添加到一级菜单
	pM_1.setSub_button(new Menu[]{pM_1_sub_1,pM_1_sub_2});
	menus.add(pM_1);
  	//第二个一级菜单
  	Menu pM_2 = new Menu();
  	pM_2.setName("养生馆");
  	
  	//第二个一级菜单的子菜单
  	Menu pM_2_sub_1 = new Menu();
  	pM_2_sub_1.setName("私房菜");
  	pM_2_sub_1.setType(MenuUtil.MENU_TYPE_CLICK);
  	pM_2_sub_1.setKey(MenuUtil.KEY_PERSIONAL_KITCHEN);
  	
  	Menu pM_2_sub_2 = new Menu();
	pM_2_sub_2.setName("温灸");
	pM_2_sub_2.setType(MenuUtil.MENU_TYPE_CLICK);
	pM_2_sub_2.setKey(MenuUtil.KEY_WARM_MOXIBUSTION);
	//添加到一级菜单，并添加到menus
	pM_2.setSub_button(new Menu[]{pM_2_sub_1,pM_2_sub_2});
	menus.add(pM_2);
	
	return menus;
} 

/**
 * 
 * @param accessToken
 * @return 
 */
public static int deleteMenu(String accessToken) {
	
	 String url = MenuUtil.MENU_DELETE_URL.replace("ACCESS_TOKEN", accessToken);  
	
	 // 调用接口创建菜单  
     JSONObject jsonObject = ConnectWechatUtil.httpRequest(url, "GET",null);  
     
     int result = 0;  
     
     if (null != jsonObject) {  
         if (0 != jsonObject.getInt("errcode")) {  
             result = jsonObject.getInt("errcode");  
             //log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
         }  
     }  
   
     return result;  
}

}
