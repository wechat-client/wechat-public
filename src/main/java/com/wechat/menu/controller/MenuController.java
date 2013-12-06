package com.wechat.menu.controller;


import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.wechat.common.utils.ConnectWechatUtil;
import com.wechat.common.utils.MenuUtil;
import com.wechat.menu.pojo.Menu;
import com.wechat.menu.pojo.TokenPojo;
import com.wechat.menu.service.MenuService;
import com.wechat.user.pojo.User;
import com.wechat.app.pojo.App;
import com.wechat.app.service.IAppService;




@Controller
public class MenuController {
@Autowired
MenuService  ms;



@Resource(name="appService")
private IAppService appService;


// @RequestMapping("/menu/createMenu")
// public String InitMenuController(){
// 
//// List<Menu> menus = ms.getMenu(user, app);
//// return "createMenu";
//// }





@RequestMapping("/menu/menuSucess")
public String saveMenuController(Menu menu,HttpServletRequest request){
User user= (User) request.getSession().getAttribute("User");
App app =  appService.getUserApps(user.getUserId()).get(0);
TokenPojo  accessToken  = ConnectWechatUtil.getAccessToken(app.getAppKey(),app.getAppSecret());
int result = 0;  


//拿到数据库得menu
List<Menu> dbmenus = ms.getMenu(user, app);
// 拼装创建菜单的url  
String url =MenuUtil. MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken.getToken());  
  // 将菜单对象转换成json字符串  
        //String jsonMenu = JSONObject.fromObject(button).toString().trim();  
        JSONObject jsonMenu = new JSONObject();
        JSONArray jsonArr = new JSONArray();  
        JsonConfig jc = new JsonConfig();
        jc.setExcludes(new String[]{"appId","menuId","parentId"});
//       // jc.setJavaPropertyFilter(javaPropertyFilter);
//        jsonMenu.fromObject(dbmenus, jc);
            


        String jsonresult = jsonArr.fromObject(dbmenus, jc).toString();
        jsonMenu.put("button", jsonresult); 
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
        //ms.createMenu(menus);
        	return "menuSucess";
        }


}

}

