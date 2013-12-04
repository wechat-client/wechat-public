package com.wechat.menu.manager;


import java.util.ArrayList;
import java.util.List;

import com.wechat.menu.pojo.*;
import com.wechat.wechatutil.MainUtil;
import com.wechat.wechatutil.MenuUtil;


public class MenuManager {
	
    public static void main(String[] args) {  
        // 第三方用户唯一凭证  
        String appId = "wx136d668a243902c0";  
        // 第三方用户唯一凭证密钥  
        String appSecret = "1d557540724ec17578433e3040ebacf3";  
  
        // 调用接口获取access_token  
        TokenPojo at = MainUtil.getAccessToken(appId, appSecret);  
  
        if (null != at) {  
            // 调用接口创建菜单  
            int result = MenuUtil.createMenu(getMenu(), at.getToken());  
        }  
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
    	pM_1_sub_2.setType(MenuUtil.MENU_TYPE_VIEW);
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

}
