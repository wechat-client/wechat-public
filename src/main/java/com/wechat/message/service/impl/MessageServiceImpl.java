package com.wechat.message.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wechat.common.exception.WechatEcxeption;
import com.wechat.message.dao.IMessageDao;
import com.wechat.message.dao.impl.MessageDaoJDBCImpl;
import com.wechat.message.pojo.Message;
import com.wechat.message.service.IMessageService;

/**
 * @ file_name MessageServiceImpl.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月10日下午5:05:32
 * @ description
 * @ reviewed_by 
 */
@Service("messageService")
public class MessageServiceImpl implements IMessageService {

	@Resource(name="messageDao")
	private IMessageDao messageDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.wechat.message.service.IMessageService#saveMessage(com.wechat.message.pojo.Message)
	 */
	public void saveMessage(Message message) throws WechatEcxeption {
		messageDao.saveMessage(message);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wechat.message.service.IMessageService#findMessageByMenu(java.lang.String)
	 */
	public Message findMessageByMenu(String menuCode) {
		return messageDao.loadMessageByMenuCode(menuCode);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wechat.message.service.IMessageService#findMessageByEvent(java.lang.String)
	 */
	public Message findMessageByEvent(String eventCode) {
		
		return messageDao.loadMessageByEventCode(eventCode);
		
	}

}
