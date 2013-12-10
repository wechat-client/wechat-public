package com.wechat.message.pojo.music;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class Music implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6066948609862471068L;

	//主键 忽略
	@XStreamOmitField private Integer musicId;
	//发送
	@XStreamAlias("Title") private String musicTitle;
	//发送
	@XStreamAlias("Description") private String musicDescription;
	//发送
	@XStreamAlias("MusicUrl") private String musicUrl;
	//发送
	@XStreamAlias("HQMusicUrl") private String hQMusicUrl;
	//发送
	@XStreamAlias("ThumbMediaId") private String thumbMediaId;
	
	public Music() {

	}
	
	public Integer getMusicId() {
		return musicId;
	}
	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
	}
	public String getMusicTitle() {
		return musicTitle;
	}
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	public String getMusicDescription() {
		return musicDescription;
	}
	public void setMusicDescription(String musicDescription) {
		this.musicDescription = musicDescription;
	}
	public String getMusicUrl() {
		return musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	public String gethQMusicUrl() {
		return hQMusicUrl;
	}
	public void sethQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	
	
	
}
