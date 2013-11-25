package com.wechat.pojo;

public class ComplexMenu extends MenuBasic{

    private MenuBasic[] sub_menu;  
    
    public MenuBasic[] getSub_button() {  
        return sub_menu;  
    }  
  
    public void setSub_button(MenuBasic[] sub_menu) {  
        this.sub_menu = sub_menu;  
    }  
}
