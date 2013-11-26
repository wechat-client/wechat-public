package com.wechat.message.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wechat.message.pojo.Article;
import com.wechat.message.pojo.NewsMessage;
import com.wechat.message.pojo.TextMessage;
import com.wechat.message.util.MessageUtil;

public class MessageService {

	/** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";  
  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
  
            // 回复文本消息  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
            
            
            // 回复图文消息
            NewsMessage newsMessage = new NewsMessage();  
            newsMessage.setToUserName(fromUserName);  
            newsMessage.setFromUserName(toUserName);  
            newsMessage.setCreateTime(new Date().getTime());  
            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
            newsMessage.setFuncFlag(0); 
  
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
                respContent = "您发送的是文本消息！";  
            }  
            // 图片消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "您发送的是图片消息！";  
            }  
            // 地理位置消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "您发送的是地理位置消息！";  
            }  
            // 链接消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "您发送的是链接消息！";  
            }  
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "您发送的是音频消息！";  
            } 
            
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    respContent = "欢迎关注非姐的养生分享并积极参与，非常感谢！";  
                }  
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                    respContent = "谢谢您得关注！";
                }  
                // 自定义菜单点击事件  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                	
                    
                    
                    // TODO 自定义菜单权没有开放，暂不处理该类消息 
                	 String eventKey = requestMap.get("EventKey"); 
                	 //return newsMessage
                	if(eventKey.equals("2")){
                		
                		
                		

                   	    List<Article> articleList = new ArrayList<Article>(); 
                        
                        Article article1 = new Article();  
                        article1.setTitle("小非私房菜\n引言");  
                        article1.setDescription("");  
                        article1.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");  
                        article1.setUrl("http://blog.csdn.net/lyq8479/article/details/8937622");  
      
                        Article article2 = new Article();  
                        article2.setTitle("第2篇\n微信公众帐号的类型");  
                        article2.setDescription("");  
                        article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                        article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8941577");  
      
                        Article article3 = new Article();  
                        article3.setTitle("第3篇\n开发模式启用及接口配置");  
                        article3.setDescription("");  
                        article3.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                        article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8944988");  
      
                        articleList.add(article1);  
                        articleList.add(article2);  
                        articleList.add(article3);  
                        newsMessage.setArticleCount(articleList.size());  
                        newsMessage.setArticles(articleList); 
                		
                	}
                
                }  
            }  
  
            if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
            	 
                respMessage = MessageUtil.newsMessageToXml(newsMessage); 
            }else{
            	  textMessage.setContent(respContent);  
                  respMessage = MessageUtil.textMessageToXml(textMessage); 
            }
           
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return respMessage;  
    }  
}
