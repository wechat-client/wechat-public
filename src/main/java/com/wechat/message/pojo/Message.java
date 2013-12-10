package com.wechat.message.pojo;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.wechat.common.utils.json.JSONAlias;
import com.wechat.common.utils.json.JSONOmitField;

public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4682154958741147517L;
	//主键，发送消息时忽略
	@JSONOmitField @XStreamOmitField private Integer messageId;
	//设置发送被动响应消息时别称
	@JSONAlias("touser") @XStreamAlias("ToUserName") private String messageToUser;
	//设置发送被动响应消息时别称
	@JSONOmitField @XStreamAlias("FromUserName") private String messageFromUser;
	//设置发送被动响应消息时别称
	@JSONAlias("msgtype") @XStreamAlias("MsgType") private String messageType;
	//设置发送被动响应消息时别称
	@JSONOmitField @XStreamAlias("CreateTime") private String messageCreateTime;

	public Message() {
	
	}

	public Message(Integer messageId, String messageToUser,
			String messageFromUser, String messageType, String messageCreateTime) {
		
		this.messageId = messageId;
		this.messageToUser = messageToUser;
		this.messageFromUser = messageFromUser;
		this.messageType = messageType;
		this.messageCreateTime = messageCreateTime;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessageToUser() {
		return messageToUser;
	}

	public void setMessageToUser(String messageToUser) {
		this.messageToUser = messageToUser;
	}

	public String getMessageFromUser() {
		return messageFromUser;
	}

	public void setMessageFromUser(String messageFromUser) {
		this.messageFromUser = messageFromUser;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessageCreateTime() {
		return messageCreateTime;
	}

	public void setMessageCreateTime(String messageCreateTime) {
		this.messageCreateTime = messageCreateTime;
	}
	
	
	

}
