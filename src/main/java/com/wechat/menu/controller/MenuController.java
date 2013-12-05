package com.wechat.menu.controller;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wechat.common.utils.ConnectWechatUtil;
import com.wechat.common.utils.MenuUtil;
import com.wechat.menu.pojo.Menu;
import com.wechat.menu.service.MenuService;


@Controller
public class MenuController {
	@Autowired
	MenuService  ms;

	@RequestMapping("/createMenu")
	public String InitMenuController(){
		return "createMenu";
	}
	
	@RequestMapping("/menuSucess")
	public String saveMenuController(Menu menu){
		 String  accessToken  = "";
		 int result = 0;  
		//拿到页面得menu
		List<Menu> menus = ms.getMenu();
		// 拼装创建菜单的url  
		String url =MenuUtil. MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);  
		  // 将菜单对象转换成json字符串  
        //String jsonMenu = JSONObject.fromObject(button).toString().trim();  
        JSONObject jsonMenu = new JSONObject();
        jsonMenu.put("button", menus);     
        // 调用接口创建菜单  
        JSONObject jsonObject = ConnectWechatUtil.httpRequest(url, "POST", jsonMenu.toString());  
        if (null != jsonObject) {  
            if (0 != jsonObject.getInt("errcode")) {  
                result = jsonObject.getInt("errcode");  
                //log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
            }  
        } 
        //判断结果
        if(result != 0){
        		return "error";
        }else{
        		ms.createMenu(menus);
        		return "menuSucess";
        }
        
	}
	
	

}

