package com.wechat.message.pojo.music;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wechat.message.pojo.Message;

@XStreamAlias("xml")
public class MusicMessage extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2489896811922601352L;
	
	@XStreamAlias("Music") private Music music;
	
	public MusicMessage() {

	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	
	
}
