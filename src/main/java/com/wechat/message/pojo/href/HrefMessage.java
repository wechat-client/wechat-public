package com.wechat.message.pojo.href;

import com.wechat.message.pojo.Message;

public class HrefMessage extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3355820768198783968L;
	
	private Integer hrefId;
	private String hrefTitle;
	private String hrefDescription;
	private String hrefUrl;
	private String msgId;

	
	public HrefMessage() {

	}
	public HrefMessage(Message msg) {
		setMessageId(msg.getMessageId());
		setMessageType(msg.getMessageType());
		setMessageCreateTime(msg.getMessageCreateTime());
		setMessageFromUser(msg.getMessageFromUser());
		setMessageToUser(msg.getMessageToUser());
	}
	public String getHrefTitle() {
		return hrefTitle;
	}

	public void setHrefTitle(String hrefTitle) {
		this.hrefTitle = hrefTitle;
	}

	public String getHrefDescription() {
		return hrefDescription;
	}

	public void setHrefDescription(String hrefDescription) {
		this.hrefDescription = hrefDescription;
	}

	public String getHrefUrl() {
		return hrefUrl;
	}

	public void setHrefUrl(String hrefUrl) {
		this.hrefUrl = hrefUrl;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public Integer getHrefId() {
		return hrefId;
	}

	public void setHrefId(Integer hrefId) {
		this.hrefId = hrefId;
	}

}
