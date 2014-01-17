package com.wechat.article.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wechat.article.dao.IArticleDao;
import com.wechat.article.pojo.Article;

/**
 * @ file_name ArticleJDBCDao.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月17日下午2:12:47
 * @ description
 * @ reviewed_by 
 */
@Repository("articleDao")
public class ArticleJDBCDao implements IArticleDao{

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Article> findArticleByPage(int firstResult, int maxResult,String category) {
	
		String sql = "select article_id,article_publish_time,article_abstract,article_title,article_content,article_category,article_image from wechat_article where article_category=? limit ?,?";
		
		List<Article> articles = jdbcTemplate.query(sql, new Object[]{category,firstResult,maxResult}, new RowMapper<Article>(){
			@Override
			public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
				Article article = new Article();
				article.setArticleId(rs.getInt("article_id"));
				article.setArticlePublishTime(rs.getLong("article_publish_time"));
				article.setArticleAbstract(rs.getString("article_abstract"));
				article.setArticleTitle(rs.getString("article_title"));
				article.setArticleContent(rs.getString("article_content"));
				article.setArticleCategory(rs.getString("article_category"));
				article.setArticleImage(rs.getString("article_image"));
				return article;
			}
		});
		
		return articles;
	}
	

	@Override
	public Article findArticle(Integer articleId) {
		String sql = "select  article_id,article_publish_time,article_abstract,article_title,article_content,article_category,article_image from wechat_article where article_id=?";
		Article article = jdbcTemplate.queryForObject(sql, new Object[]{articleId}, new RowMapper<Article>(){

			@Override
			public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
				Article article = new Article();
				article.setArticleId(rs.getInt("article_id"));
				article.setArticlePublishTime(rs.getLong("article_publish_time"));
				article.setArticleAbstract(rs.getString("article_abstract"));
				article.setArticleTitle(rs.getString("article_title"));
				article.setArticleContent(rs.getString("article_content"));
				article.setArticleCategory(rs.getString("article_category"));
				article.setArticleImage(rs.getString("article_image"));
				return article;
			}
			
		});
		return article;
	}

	
}
