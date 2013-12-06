package com.wechat.menu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.wechat.app.pojo.App;
import com.wechat.common.utils.ConnectWechatUtil;
import com.wechat.common.utils.MenuUtil;
import com.wechat.menu.dao.IMenuDao;
import com.wechat.menu.pojo.Menu;
import com.wechat.user.pojo.User;

@Service
public class MenuService implements IMenuService{
	
	@Resource(name="menuDao")
	private IMenuDao menuDao;
		
/** 
 * 组装菜单数据 
 * @return 
 */  
public  List<Menu> getMenu(User user, App app) {  
	List<Menu> menus = new ArrayList<Menu>();
	Integer userid = user.getUserId();
	Integer appid = app.getAppId();
	menus = menuDao.getMenuByUser(userid, appid);
	List<Menu>treemenus = createMenu(menus);
	return treemenus;
	//menus = 
//	//第一个一级菜单
//  	Menu pM_1 = new Menu();
//  	pM_1.setName("非姐养生");
//  	
//  	
//  	//第一个一级菜单的子菜单
//  	Menu pM_1_sub_1 = new Menu();
//  	pM_1_sub_1.setName("非姐淘宝小铺");
//	pM_1_sub_1.setType(MenuUtil.MENU_TYPE_VIEW);
//	pM_1_sub_1.setUrl("https://shop106322402.m.taobao.com/");
//	
//	Menu pM_1_sub_2 = new Menu();
//	pM_1_sub_2.setName("非姐V付");
//	pM_1_sub_2.setType(MenuUtil.MENU_TYPE_CLICK);
//	pM_1_sub_2.setKey(MenuUtil.KEY_V_PAY);
//	
//	//添加到一级菜单
//	pM_1.setSub_button(new Menu[]{pM_1_sub_1,pM_1_sub_2});
//	menus.add(pM_1);
//  	//第二个一级菜单
//  	Menu pM_2 = new Menu();
//  	pM_2.setName("养生馆");
//  	
//  	//第二个一级菜单的子菜单
//  	Menu pM_2_sub_1 = new Menu();
//  	pM_2_sub_1.setName("私房菜");
//  	pM_2_sub_1.setType(MenuUtil.MENU_TYPE_CLICK);
//  	pM_2_sub_1.setKey(MenuUtil.KEY_PERSIONAL_KITCHEN);
//  	
//  	Menu pM_2_sub_2 = new Menu();
//	pM_2_sub_2.setName("温灸");
//	pM_2_sub_2.setType(MenuUtil.MENU_TYPE_CLICK);
//	pM_2_sub_2.setKey(MenuUtil.KEY_WARM_MOXIBUSTION);
//	//添加到一级菜单，并添加到menus
//	pM_2.setSub_button(new Menu[]{pM_2_sub_1,pM_2_sub_2});
//	menus.add(pM_2);
	
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


/** 
 * 创建菜单 
 *  
 * @param menu 菜单实例 
 * @param accessToken 有效的access_token 
 * @return 0表示成功，其他值表示失败 
 */  
public  List<Menu> createMenu(List<Menu> menus) {  
	
	Map<Integer,Menu>  mapMenus = new HashMap<Integer,Menu>();
	for(Menu menu : menus){
		if(menu.getParentId() == null || menu.getParentId() ==0){
			mapMenus.put(menu.getMenuId(), menu);
		}
	}

	for(Menu m : menus){
		if(m.getParentId()!=null && m.getParentId() != 0){			
			List<Menu> subMenus = mapMenus.get(m.getParentId()).getSub_button();
			if(subMenus==null){
				subMenus = new ArrayList<Menu>();
			}
			subMenus.add(m);
			mapMenus.get(m.getParentId()).setSub_button(subMenus);
		}
	}
	
	List<Menu> treeMenus = new ArrayList<Menu>(mapMenus.size());
	Iterator<Integer> its = mapMenus.keySet().iterator();
	while(its.hasNext()){
		treeMenus.add(mapMenus.get(its.next()));
	}
		
	return treeMenus ;
	}

}
