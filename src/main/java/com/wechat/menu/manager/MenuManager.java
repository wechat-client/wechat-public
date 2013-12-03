package com.wechat.menu.manager;

import com.wechat.menu.pojo.Menu;
import com.wechat.menu.pojo.*;
import com.wechat.wechatutil.MainUtil;


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
            int result = MainUtil.createMenu(getMenu(), at.getToken());  
        }  
    }  
  
    /** 
     * 组装菜单数据 
     *  
     * @return 
     */  
    private static WeChatMenu getMenu() {  
        Menu vm = new Menu();
        vm.setName("非姐淘宝小铺");
        vm.setUrl("https://shop106322402.m.taobao.com/");
        vm.setType("view");
        
        Menu cm0 = new Menu();
        cm0.setName("非姐V付");
        cm0.setType("click");
        cm0.setKey("4");
 
        CommonMenu cm1 = new CommonMenu();
        cm1.setName("私房菜");
        cm1.setType("click");
        cm1.setKey("2");
        
        CommonMenu cm2 = new CommonMenu();
        cm2.setName("温灸");
        cm2.setType("click");
        cm2.setKey("3");
        
        ComplexMenu clm = new ComplexMenu();
        clm.setName("非姐养生");
        clm.setSub_button(new CommonMenu[] {cm1,cm2});
        
        ComplexMenu clmshop  = new ComplexMenu();
        clmshop.setName("养生馆");
        clmshop.setSub_button(new Menu[]{vm,cm0});
        
        
  
        /** 
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br> 
         *  
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br> 
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        WeChatMenu button = new WeChatMenu();  
        button.setButton(new MenuBasic[] {clmshop,clm}); 
        return button;  
    }  

}
