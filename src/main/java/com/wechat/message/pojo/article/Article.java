package com.wechat.message.pojo.article;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("item")
public class Article implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6074355380329779263L;
	
	@XStreamOmitField private Integer articleId;
    // 图文消息名称  
	@XStreamAlias("Title") private String articleTitle;  
    // 图文消息描述  
	@XStreamAlias("Description") private String articleDescription;  
    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致  
	@XStreamAlias("PicUrl") private String articlePicUrl;  
    // 点击图文消息跳转链接  
	@XStreamAlias("Url")  private String articleUrl;  
    
    @XStreamOmitField private Integer messageId;

    public Article() {

    }
    
	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}

	public String getArticlePicUrl() {
		return articlePicUrl;
	}

	public void setArticlePicUrl(String articlePicUrl) {
		this.articlePicUrl = articlePicUrl;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
  
    

    
    
}
