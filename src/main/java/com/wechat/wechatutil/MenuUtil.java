package com.wechat.wechatutil;

import java.util.List;

import net.sf.json.JSONObject;

import com.wechat.menu.pojo.Menu;

public class MenuUtil {
	
	/*menu的类型为click类型，有key值*/
	public static final String MENU_TYPE_CLICK = "click";
	/*menu类型为view类型，有Url*/
	public static final String MENU_TYPE_VIEW = "view";
	
	//非姐V支付key code
	public static final String KEY_V_PAY = "v_pay";
	//私房菜key code
	public static final String KEY_PERSIONAL_KITCHEN = "personal_kitchen";
	//温灸
	public static final String KEY_WARM_MOXIBUSTION = "warm_moxibustion";
	
	// 菜单创建（POST） 限100（次/天）  
    public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";  
    
    
    /** 
     * 创建菜单 
     *  
     * @param menu 菜单实例 
     * @param accessToken 有效的access_token 
     * @return 0表示成功，其他值表示失败 
     */  
    public static int createMenu(List<Menu> menus, String accessToken) {  
        int result = 0;  
      
        // 拼装创建菜单的url  
        String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);  
        // 将菜单对象转换成json字符串  
        //String jsonMenu = JSONObject.fromObject(button).toString().trim();  
        JSONObject jsonMenu = new JSONObject();
        jsonMenu.put("button", menus);
        
        System.out.println(accessToken);
        
        System.out.println(jsonMenu);
 
        // 调用接口创建菜单  
        JSONObject jsonObject = MainUtil.httpRequest(url, "POST", jsonMenu.toString());  
      
        if (null != jsonObject) {  
            if (0 != jsonObject.getInt("errcode")) {  
                result = jsonObject.getInt("errcode");  
                //log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
            }  
        }  
      
        return result;  
    }
}
