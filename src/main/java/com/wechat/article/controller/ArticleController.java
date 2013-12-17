package com.wechat.article.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wechat.article.service.IArticleService;
import com.wechat.article.service.impl.ArticleServiceImpl;
import com.wechat.common.exception.WechatEcxeption;
import com.wechat.common.utils.Pagination;

/**
 * @ file_name ArticleController.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月17日上午10:16:05
 * @ description
 * @ reviewed_by 
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Resource(name="articleService")
	private IArticleService articleService;
	
	@RequestMapping("/list/{category}")
	public String articleList(@PathVariable String category,Model model) throws WechatEcxeption{
		Pagination page = new Pagination(1);
		model.addAttribute("articles", articleService.findPageByCategory(page, category));
		return "frontviews/article-list";
	}
	@RequestMapping("/{articleId}")
	public String articleList(@PathVariable Integer articleId,Model model){
		model.addAttribute("article", articleService.findByArticleId(articleId));
		return "frontviews/article";
	}

}
