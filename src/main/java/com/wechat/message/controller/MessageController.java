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
        try {
        	// xml请求解析  
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
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
                	String subscribe = processSubscribeRequest(msgType,fromUserName,toUserName);
                	logger.info("subscribe:"+subscribe);
                	return subscribe;
                }
                //地理位置事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                	
                }  
                //点击菜单事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                	//得到key_code
                    String keyCode = requestMap.get("EventKey");
                    //按 keyCode响应
                    Message message = messageService.findMessageByMenu(keyCode);
                    if(message == null){
                    	return defaultResponse(fromUserName,toUserName);
                    }else{
                    	message.setMessageFromUser(toUserName);
                    	message.setMessageToUser(fromUserName);
                    	message.setMessageCreateTime(String.valueOf(new Date().getTime()));
                    	String xmlMessage = MessageUtil.messageToXml(message);
                    	if(xmlMessage!=null) return xmlMessage;
                    	return defaultResponse(fromUserName, toUserName);
                    }
                }  
            }
		} catch (Exception e) {
			e.printStackTrace();
		}  
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
	private String defaultResponse(String fromUserName, String toUserName) {
		TextMessage textMessage = new TextMessage();
		textMessage.setContent("亲,这个功能正在完善中...");
		textMessage.setMessageFromUser(toUserName);
		textMessage.setMessageToUser(fromUserName);
		textMessage.setMessageType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setMessageCreateTime(String.valueOf(new Date().getTime()));
		return MessageUtil.messageToXml(textMessage);
	}
	public String processSubscribeRequest(String msgType, String fromUserName,
			String toUserName) {
		ArticleMessage newsMessage = new ArticleMessage();
		
		newsMessage.setMessageCreateTime(String.valueOf(new Date().getTime()));
		newsMessage.setMessageFromUser(toUserName);
		newsMessage.setMessageToUser(fromUserName);
		newsMessage.setMessageType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		
		List<Article> articles = new ArrayList<Article>();
		Article article1 = new Article();  
	    article1.setArticleTitle("小非私房菜\n引言");  
	    article1.setArticleDescription("");  
	    article1.setArticlePicUrl(ConnectWechatUtil.APP_CONTEXT_IMAGE_URL + "food.jpg");  
	    article1.setArticleUrl("");  
	    articles.add(article1);
		Article article2 = new Article();  
		article2.setArticleTitle("第2篇\n最简单剁椒鱼做法");  
		article2.setArticleDescription("湘菜的剁椒鱼头分为红色泡椒和绿色酱椒两种，一般来说，红色比较普遍，但是绿色才真的美味。而且剁椒鱼头的肉大且粗\n");  
		article2.setArticlePicUrl(ConnectWechatUtil.APP_CONTEXT_IMAGE_URL + "yutou.jpg");  
		article2.setArticleUrl("http://mp.weixin.qq.com/mp/appmsg/show?__biz=MjM5MTI5NzMyNQ==&appmsgid=10000139&itemidx=1&sign=acf99d39411954471b5146a2eba27eb3#wechat_redirect");  
		articles.add(article2);
		Article article3 = new Article();  
		article3.setArticleTitle("第3篇\n自制山楂糕");  
		article3.setArticleDescription("");  
		article3.setArticlePicUrl(ConnectWechatUtil.APP_CONTEXT_IMAGE_URL + "szg16.jpg");  
		article3.setArticleUrl("http://mp.weixin.qq.com/mp/appmsg/show?__biz=MjM5MTI5NzMyNQ==&appmsgid=10000134&itemidx=1&sign=b6e2d56fcce159b2b0bfe98d369cdb2b#wechat_redirect");  
		articles.add(article3);
		Article article4 = new Article();  
		article4.setArticleTitle("第4篇\n白菜煮虾做法");  
		article4.setArticleDescription("");  
		article4.setArticlePicUrl(ConnectWechatUtil.APP_CONTEXT_IMAGE_URL + "getimgdata.jpg");  
		article4.setArticleUrl("http://mp.weixin.qq.com/mp/appmsg/show?__biz=MjM5MTI5NzMyNQ==&appmsgid=10000126&itemidx=1&sign=815d188401f8ec9d035b5dd39ff5c738#wechat_redirect");  
		articles.add(article4);  
		
		newsMessage.setArticleCount(articles.size());
		newsMessage.setArticles(articles);
		
		return MessageUtil.messageToXml(newsMessage);
	}

	
}

