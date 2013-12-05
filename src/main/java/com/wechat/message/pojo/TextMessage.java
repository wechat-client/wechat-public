package com.wechat.message.pojo;


public class TextMessage extends Message{

	   // 消息内容  
    private String Content;  
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        Content = content;  
    }  
    
    @Override
    public String toString() {
    	
    	return "{\"touser\":\""+this.getToUserName()+"\",\"msgtype\":\""+this.getMsgType()+"\",\"text\":{\"content\":\""+this.getContent()+"\"}}";
    
    }
    
}
