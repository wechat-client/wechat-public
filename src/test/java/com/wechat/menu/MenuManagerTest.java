package com.wechat.menu;

import java.util.List;

import net.sf.json.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import com.wechat.menu.controller.MenuController;
import com.wechat.menu.pojo.Menu;
import com.wechat.menu.pojo.TokenPojo;
import com.wechat.common.utils.ConnectWechatUtil;

public class MenuManagerTest {
	
	
	// 第三方用户唯一凭证  
    String appId = "wx136d668a243902c0";  
    // 第三方用户唯一凭证密钥  
    String appSecret = "1d557540724ec17578433e3040ebacf3";  

    
    

	/**
	 *测试menu生成的json是否符合需求
	 
	@Test
	public void testMenuJSON(){
		List<Menu> menus = MenuManager.getMenu();
		JSONObject jsonMenu = new JSONObject();
		jsonMenu.put("button", menus);
		System.out.println(jsonMenu.toString());
	}*/
	/**
	 * 测试删除menu
	
	@Test
	public void testDeleteMenu(){

        // 调用接口获取access_token  
        TokenPojo at = MainUtil.getAccessToken(appId, appSecret);  
        int result = MenuManager.deleteMenu(at.getToken());
        Assert.assertEquals(0, result);
       
	} */
	
	/**
	 * 测试添加menu
	 
	@Test
	public void testCreateMenu(){
        // 调用接口获取access_token  
        TokenPojo at = MainUtil.getAccessToken(appId, appSecret);  
        //创建menu
        List<Menu> menus = MenuManager.getMenu();
        
        int result = MenuManager.createMenu(menus, at.getToken());
        Assert.assertEquals(0, result);
       
	}*/
}
