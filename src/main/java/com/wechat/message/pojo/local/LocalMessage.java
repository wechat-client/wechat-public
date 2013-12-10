package com.wechat.message.pojo.local;

import com.wechat.message.pojo.Message;

/**
 * 地理位置消息
 * @author sence
 *
 */
public class LocalMessage extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7532572729756661787L;

	private Integer localMessageId;
	
	private String localX;
	
	private String localY;
	
	private String scale;
	
	private String label;
	
	private String msgId;
	
	public LocalMessage() {

	}
	
	public Integer getLocalMessageId() {
		return localMessageId;
	}
	public void setLocalMessageId(Integer localMessageId) {
		this.localMessageId = localMessageId;
	}
	public String getLocalX() {
		return localX;
	}
	public void setLocalX(String localX) {
		this.localX = localX;
	}
	public String getLocalY() {
		return localY;
	}
	public void setLocalY(String localY) {
		this.localY = localY;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	
	
	
}
