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
	

	public Vedio getVedio() {
		return vedio;
	}

	public void setVedio(Vedio vedio) {
		this.vedio = vedio;
	}
	
	
	
}
