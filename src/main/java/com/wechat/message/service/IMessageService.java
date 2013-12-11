package com.wechat.message.service;

import com.wechat.common.exception.WechatEcxeption;
import com.wechat.message.pojo.Message;

/**
 * @ file_name IMessageService.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月10日下午5:00:14
 * @ description
 * @ reviewed_by 
 */
public interface IMessageService {

	public void saveMessage(Message message) throws WechatEcxeption;
	
	public Message findMessageByMenu(String menuCode);
	
}
