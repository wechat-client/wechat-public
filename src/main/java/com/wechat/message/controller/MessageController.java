package com.wechat.message.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wechat.common.exception.WechatEcxeption;
import com.wechat.common.utils.ConnectWechatUtil;
import com.wechat.common.utils.MessageUtil;
import com.wechat.common.utils.SignUtil;
import com.wechat.message.pojo.Message;
import com.wechat.message.pojo.article.Article;
import com.wechat.message.pojo.article.ArticleMessage;
import com.wechat.message.pojo.text.TextMessage;
import com.wechat.message.service.IMessageService;


@Controller
public class MessageController {
	
	Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Resource(name="messageService")
	private IMessageService messageService;

	@RequestMapping(value="/wechatClient",method=RequestMethod.GET)
	public @ResponseBody String ensureWechatCallBack(String signature,String timestamp,String nonce,String echostr){
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
           return echostr;
        }
        return "error";
	}
	//设置响应的编码
	@RequestMapping(value="/wechatClient",method=RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	public @ResponseBody String responseWechatPushInfo(HttpServletRequest request){
		Message message = null;
		String fromUserName = null;
		String toUserName = null;
		try {
        	// xml请求解析  
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送方帐号（open_id）  
            fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
            //文本类型
            if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)){
            	//processRequest(msgType,fromUserName,toUserName);
            }
            //图片类型
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)){
            	//processRequest(msgType,fromUserName,toUserName);
            }
            //语音类型
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)){
            	//processRequest(msgType,fromUserName,toUserName);
            }
            //视频类型
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VEDIO)){
            	//processRequest(msgType,fromUserName,toUserName);
            }
            //地理位置
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)){
            	//processRequest(msgType,fromUserName,toUserName);
            }
            //链接类型
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)){
            	//processRequest(msgType,fromUserName,toUserName);
            }
            //事件推送
            if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
            	// 消息类型  
                String eventType = requestMap.get("Event");
                //订阅类型 退订类型不响应
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                	String ticket = requestMap.get("Ticket");
                	//1、是通过扫描来关注的
                	if(ticket!=null){
                		message = messageService.findMessageByEvent(MessageUtil.EVENT_TYPE_SCAN_SUBSCRIBE);
                	}
                	//2、不是通过扫描或者没配置扫描关注
                	if(message==null){
                		message = messageService.findMessageByEvent(MessageUtil.EVENT_TYPE_SUBSCRIBE);
                	}
                	
                }
                //扫描二维码
                if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                	message = messageService.findMessageByEvent(MessageUtil.EVENT_TYPE_SCAN);
                }
                //退订
                if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                	//默认不响应
                }
                
                //地理位置事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {  
                	message = messageService.findMessageByEvent(MessageUtil.EVENT_TYPE_LOCATION);
                }  
                //点击菜单事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                	//得到key_code
                    String keyCode = requestMap.get("EventKey");
                    //按 keyCode响应
                    message = messageService.findMessageByMenu(keyCode);
                    if(message == null){
                    	return defaultResponse(fromUserName,toUserName);
                    }
                }  
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		//message不为空，说明有消息
		if(message!=null){
			message.setMessageFromUser(toUserName);
	    	message.setMessageToUser(fromUserName);
	    	message.setMessageCreateTime(String.valueOf(new Date().getTime()));
	    	String xmlMessage = MessageUtil.messageToXml(message);
	    	if(xmlMessage!=null) return xmlMessage;
		}
		//否则目前不返回任何东西
		return null;
       
       
	}
	
	@RequestMapping("/saveTextMessage")
	public @ResponseBody String saveTextMessage() throws WechatEcxeption{
		TextMessage textMessage = new TextMessage();
		//要注意null值所对应的属性，是不转化为xml里面的标签的
		textMessage.setContent("这个是测试的温灸养生里面的内容");
		textMessage.setMessageType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
		messageService.saveMessage(textMessage);
		return "success";
	}
	@RequestMapping("/saveNewsMessage")
	public @ResponseBody String saveNewsMessage() throws WechatEcxeption{
		ArticleMessage message = new ArticleMessage();
		message.setMessageType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		List<Article> articles = new ArrayList<Article>();
		Article article = new Article();
		article.setArticleDescription("当我朝着反方向走去，在楼梯的角落找勇气，曾经并肩往前的伙伴，沉默着懂得我的委屈，时间她总说谎，我从不曾失去那些肩膀");
		article.setArticleTitle("明天，你好");
		article.setArticleUrl("#");
		article.setArticlePicUrl(ConnectWechatUtil.APP_CONTEXT_IMAGE_URL+"food.jpg");
		articles.add(article);
		message.setArticles(articles);
		message.setArticleCount(articles.size());
		messageService.saveMessage(message);
		return "success";
	}
	
	@RequestMapping("/saveIntroMessage")
	public @ResponseBody String saveIntroMessage() throws WechatEcxeption{
		ArticleMessage newsMessage = new ArticleMessage();
		newsMessage.setMessageType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		List<Article> articles = new ArrayList<Article>();
		Article article1 = new Article();  
	    article1.setArticleTitle("小非私房菜");  
	    article1.setArticleDescription("这个是总的概要介绍，介绍非姐的个人相关信息以及说明微信号将会给订阅者带来的那些方面的内容信息");  
	    article1.setArticlePicUrl(ConnectWechatUtil.APP_CONTEXT_IMAGE_URL + "food.jpg");  
	    article1.setArticleUrl("#");  
	    articles.add(article1);
	    newsMessage.setArticleCount(articles.size());
		newsMessage.setArticles(articles);
		messageService.saveMessage(newsMessage);
		return "success";
	}
	
	private String defaultResponse(String fromUserName, String toUserName) {
		TextMessage textMessage = new TextMessage();
		textMessage.setContent("亲,这个功能正在完善中...");
		textMessage.setMessageFromUser(toUserName);
		textMessage.setMessageToUser(fromUserName);
		textMessage.setMessageType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setMessageCreateTime(String.valueOf(new Date().getTime()));
		return MessageUtil.messageToXml(textMessage);
	}
//	public String processSubscribeRequest(String msgType, String fromUserName,
//			String toUserName) {
//		ArticleMessage newsMessage = new ArticleMessage();
//		
//		newsMessage.setMessageCreateTime(String.valueOf(new Date().getTime()));
//		newsMessage.setMessageFromUser(toUserName);
//		newsMessage.setMessageToUser(fromUserName);
//		newsMessage.setMessageType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
//		
//		List<Article> articles = new ArrayList<Article>();
//		Article article1 = new Article();  
//	    article1.setArticleTitle("小非私房菜");  
//	    article1.setArticleDescription("这个是总的概要介绍，介绍非姐的个人相关信息以及说明微信号将会给订阅者带来的那些方面的内容信息");  
//	    article1.setArticlePicUrl(ConnectWechatUtil.APP_CONTEXT_IMAGE_URL + "food.jpg");  
//	    article1.setArticleUrl("");  
//	    articles.add(article1);
//		
//	    newsMessage.setArticleCount(articles.size());
//		newsMessage.setArticles(articles);
//		return MessageUtil.messageToXml(newsMessage);
//	}

	
}

