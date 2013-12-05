package com.wechat.message.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wechat.common.utils.MessageUtil;
import com.wechat.common.utils.SignUtil;
import com.wechat.message.pojo.TextMessage;


@Controller
public class MessageController {

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
		String reponseContent="貌似遇到了一些问题，请等候修复";
		TextMessage textMessage = new TextMessage();  
        try {
        	// xml请求解析  
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
            
            // 回复文本消息  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
            
            if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
            	 // 消息类型  
                String eventType = requestMap.get("Event");
                //订阅类型
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                	reponseContent = "非姐养生,谢谢你的关注";  
                }  
                
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		}  
        textMessage.setContent(reponseContent);  
		return MessageUtil.textMessageToXml(textMessage); 
		
	}
	
}

