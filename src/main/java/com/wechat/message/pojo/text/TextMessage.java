package com.wechat.message.pojo.text;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.wechat.common.utils.json.JSONOmitField;
import com.wechat.message.pojo.Message;

@XStreamAlias("xml")
public class TextMessage extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 59132969153398350L;
	//主键 转为XML时忽略此属性
	@JSONOmitField @XStreamOmitField private Integer textMessageId;
	//转为XML时忽略此属性
	@JSONOmitField @XStreamOmitField private String msgId;
	//转为XML时设置别称为Content
	@XStreamAlias("Content") private String content;
	
	
	public TextMessage() {
		
	}
	
	public Integer getTextMessageId() {
		return textMessageId;
	}
	public void setTextMessageId(Integer textMessageId) {
		this.textMessageId = textMessageId;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
