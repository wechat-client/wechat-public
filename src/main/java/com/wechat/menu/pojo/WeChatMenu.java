package com.wechat.menu.pojo;

public class WeChatMenu {
	
	private MenuBasic[] mb;  
	  
  	//该处必须命名getButton
    public MenuBasic[] getButton() {  
        return mb;  
    }  
	  
	//该处必须命名getButton
	public void setButton(MenuBasic[] mb) {  
	    this.mb = mb;  
	}  

}
