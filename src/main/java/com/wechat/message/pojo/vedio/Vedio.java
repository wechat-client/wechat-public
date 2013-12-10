package com.wechat.message.pojo.vedio;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class Vedio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9109863194567370668L;

	//主键
	@XStreamOmitField private Integer vedioId;
	
	//发送响应、接收消息
	@XStreamAlias("MediaId") private String mediaId;
	//发送响应
	@XStreamAlias("Title") private String title;
	//发送响应
	@XStreamAlias("Description") private String description;
	//接受消息
	@XStreamOmitField private String thumbMediaId;
	//接受消息
	@XStreamOmitField private String msgId;
	
	public Vedio() {

	}
	
	public Integer getVedioId() {
		return vedioId;
	}
	public void setVedioId(Integer vedioId) {
		this.vedioId = vedioId;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	

}
