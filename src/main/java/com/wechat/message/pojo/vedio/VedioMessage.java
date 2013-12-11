package com.wechat.message.pojo.vedio;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wechat.message.pojo.Message;

@XStreamAlias("xml")
public class VedioMessage extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6719229010657866598L;
	//发生响应的别称
	@XStreamAlias("Video") private Vedio vedio;
	
	public VedioMessage() {

	}
	
	public VedioMessage(Message msg) {
		setMessageId(msg.getMessageId());
		setMessageType(msg.getMessageType());
		setMessageCreateTime(msg.getMessageCreateTime());
		setMessageFromUser(msg.getMessageFromUser());
		setMessageToUser(msg.getMessageToUser());
	}

	public Vedio getVedio() {
		return vedio;
	}

	public void setVedio(Vedio vedio) {
		this.vedio = vedio;
	}
	
	
	
}
