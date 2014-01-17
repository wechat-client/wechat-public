package com.wechat.article.service;

import java.util.List;

import com.wechat.article.pojo.Article;
import com.wechat.common.utils.Pagination;

/**
 * @ file_name IArticleService.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月17日下午2:35:18
 * @ description
 * @ reviewed_by 
 */
public interface IArticleService {
	
	public List<Article> findPageByCategory(Pagination page,String category);
	
	public Article findByArticleId(Integer article);

}
