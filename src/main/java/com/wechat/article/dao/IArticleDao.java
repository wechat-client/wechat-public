package com.wechat.article.dao;

import java.util.List;

import com.wechat.article.pojo.Article;


/**
 * @ file_name IArticleDao.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月17日下午2:02:29
 * @ description
 * @ reviewed_by 
 */
public interface IArticleDao {

	/**
	 * @ List<Article> findArticleByPage(IArticleDao)
	 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
	 * @ date 2013年12月17日下午2:03:34
	 * @ description 
	 * @ reviewed_by
	 */
	List<Article> findArticleByPage(int firstResult,int maxResult,String category);
	/**
	 * @ Article findArticle(IArticleDao)
	 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
	 * @ date 2013年12月17日下午2:03:59
	 * @ description 
	 * @ reviewed_by
	 */
	Article findArticle(Integer articleId);
	
}
