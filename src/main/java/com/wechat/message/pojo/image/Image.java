package com.wechat.message.pojo.image;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.wechat.common.utils.json.JSONAlias;
import com.wechat.common.utils.json.JSONOmitField;


public class Image implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3370212361918337766L;
	//主键
	@JSONOmitField @XStreamOmitField private Integer imageId;
    // 图片链接  接受普通消息、发送被动响应消息
	@JSONAlias("media_id") @XStreamAlias("MediaId") private String mediaId;
    //接受普通消息、发送时忽略
	@JSONOmitField @XStreamOmitField private String picUrl;
    //接受普通消息、发送时忽略
	@JSONOmitField @XStreamOmitField private String msgId;
    //外键 不参与接收发送消息
	@JSONOmitField @XStreamOmitField private Integer messageId;
    
    
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

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}  
	
	
    
    
}
