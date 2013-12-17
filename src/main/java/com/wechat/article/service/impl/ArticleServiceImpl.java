package com.wechat.article.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wechat.article.dao.IArticleDao;
import com.wechat.article.pojo.Article;
import com.wechat.article.service.IArticleService;
import com.wechat.common.utils.Pagination;

/**
 * @ file_name ArticleServiceImpl.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月17日下午2:35:42
 * @ description
 * @ reviewed_by 
 */
@Service("articleService")
public class ArticleServiceImpl implements IArticleService{

	@Resource(name="articleDao")
	private IArticleDao articleDao;
	
	@Override
	public List<Article> findPageByCategory(Pagination page,String category) {
		
		return articleDao.findArticleByPage(page.getFirstResult(), page.getMaxResult(),category);
	}

	@Override
	public Article findByArticleId(Integer articleId) {
		return articleDao.findArticle(articleId);
	}
	
}
