package com.wechat.message.pojo.image;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


public class Image implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3370212361918337766L;
	//主键
	@XStreamOmitField private String imageId;
    // 图片链接  接受普通消息、发送被动响应消息
	@XStreamAlias("MediaId") private String mediaId;
    //接受普通消息、发送时忽略
    @XStreamOmitField private String picUrl;
    //接受普通消息、发送时忽略
    @XStreamOmitField private String msgId;
    
    
    
	public Image() {

	}

	public Image(String mediaId, String picUrl, String msgId) {
		this.mediaId = mediaId;
		this.picUrl = picUrl;
		this.msgId = msgId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}  
	
	
    
    
}
