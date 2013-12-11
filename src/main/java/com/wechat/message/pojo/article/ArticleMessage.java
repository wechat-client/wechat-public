package com.wechat.message.pojo.article;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wechat.message.pojo.Message;

@XStreamAlias("xml")
public class ArticleMessage extends Message{
	
    /**
	 */
	private static final long serialVersionUID = -8068352314331151714L;
	
	// 图文消息个数，限制为10条以内  
    @XStreamAlias("ArticleCount") private int articleCount;  
    // 多条图文消息信息，默认第一个item为大图  
    @XStreamAlias("Articles") private List<Article> articles;  
    
    public ArticleMessage() {

    }
    
    public ArticleMessage(Message msg) {
		setMessageId(msg.getMessageId());
		setMessageType(msg.getMessageType());
		setMessageCreateTime(msg.getMessageCreateTime());
		setMessageFromUser(msg.getMessageFromUser());
		setMessageToUser(msg.getMessageToUser());
	}
    
	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
    
    

}
