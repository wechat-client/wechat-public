package com.wechat.message.pojo.image;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wechat.message.pojo.Message;

@XStreamAlias("xml")
public class ImageMessage extends Message{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6458001335758250873L;
	//别称
	@XStreamAlias("Image") private Image image;

	public ImageMessage() {

	}
	
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	
	

}
