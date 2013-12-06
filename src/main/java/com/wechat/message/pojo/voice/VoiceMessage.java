package com.wechat.message.pojo.voice;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wechat.message.pojo.Message;

@XStreamAlias("xml")
public class VoiceMessage extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7161994011596748368L;
	
	//发送被动响应消息的别称
	@XStreamAlias("Voice") private Voice voice;
	
	
	
	public VoiceMessage() {

	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	
	
}
