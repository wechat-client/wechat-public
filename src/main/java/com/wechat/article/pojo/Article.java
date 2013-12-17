package com.wechat.article.pojo;

/**
 * @ file_name Article.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月17日上午10:15:49
 * @ description
 * @ reviewed_by 
 */
public class Article {
	//温灸养生
	public static final String ARTICLE_WARM_MOXIBUSTION_CATEGORY="01";
	//非姐小厨
	public static final String ARTICLE_PERSONAL_KITCHEN_CATEGORY="02";
	//非推荐
	public static final String ARTICLE_BEST_RECOMMEND_CATEGORY="03";
	
	
	private Integer articleId;
	private String articleTitle;
	private Long articlePublishTime;
	private String articleContent;
	private String articleAbstract;
	private String articleCategory;
	private String articleImage;
	/**
	 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
	 * @ date 2013年12月17日下午2:01:27
	 * @ description 
	 * @ reviewed_by
	 */
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
	public Long getArticlePublishTime() {
		return articlePublishTime;
	}
	public void setArticlePublishTime(Long articlePublishTime) {
		this.articlePublishTime = articlePublishTime;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public String getArticleAbstract() {
		return articleAbstract;
	}
	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}
	public String getArticleCategory() {
		return articleCategory;
	}
	public void setArticleCategory(String articleCategory) {
		this.articleCategory = articleCategory;
	}
	public String getArticleImage() {
		return articleImage;
	}
	public void setArticleImage(String articleImage) {
		this.articleImage = articleImage;
	}
	
	
}
