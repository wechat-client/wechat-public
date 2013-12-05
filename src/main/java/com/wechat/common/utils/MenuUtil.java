<<<<<<< HEAD
package com.wechat.common.utils;


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
	
	
}
=======
package com.wechat.common.utils;


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
    public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";  
    // 菜单创建（POST） 限100（次/天）  
    public static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";  
    
	
}
>>>>>>> 1d30d1e5ce4a8d1a2d83bc5f96af78e2cd437011
