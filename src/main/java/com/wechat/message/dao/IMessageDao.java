package com.wechat.message.dao;

import com.wechat.common.exception.WechatEcxeption;
import com.wechat.message.pojo.Message;

/**
 * @ file_name IMessageDao.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月10日上午11:15:25
 * @ description message DAO访问
 * @ reviewed_by 
 */
public interface IMessageDao {

	/**
	 * 
	 * @ int saveMessage(IMessageDao)
	 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
	 * @ date 2013年12月10日上午11:17:12
	 * @ description 保存客户发过来的消息 或者己方发出的客服消息
	 * @ reviewed_by
	 */
	boolean saveMessage(Message message)throws WechatEcxeption;
	/**
	 * 
	 * @ Message loadMessage(IMessageDao)
	 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
	 * @ date 2013年12月10日上午11:31:06
	 * @ description 依据menuId 来查找对应的message
	 * @ reviewed_by
	 */
	Message loadMessageByMenuCode(String menuKeyCode);
	/**
	 * 
	 * @ Message loadMessageByEvent(IMessageDao)
	 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
	 * @ date 2013年12月13日上午11:29:52
	 * @ description 
	 * @ reviewed_by
	 */
	Message loadMessageByEventCode(String eventCode);
	
}
