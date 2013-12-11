package com.wechat.message.pojo.voice;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class Voice implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2475203071078058912L;

	//主键
	@XStreamOmitField private Integer voiceId;
	//发送被动消息、接收消息
	@XStreamAlias("MeidaId") private String mediaId;
	//格式、接收消息
	@XStreamOmitField private String format;
	//接收消息
	@XStreamOmitField private String msgId;
	//语音识别结果
	@XStreamOmitField private String recognition;
	//外键
	@XStreamOmitField private Integer messageId;
	
	public Voice() {
		
	}

	public Voice(String mediaId, String format, String msgId) {
		this.mediaId = mediaId;
		this.format = format;
		this.msgId = msgId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public Integer getVoiceId() {
		return voiceId;
	}

	public void setVoiceId(Integer voiceId) {
		this.voiceId = voiceId;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	
	
	
	
	
}
