package com.wechat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;














import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wechat.common.exception.WechatEcxeption;
import com.wechat.common.utils.ConnectWechatUtil;
import com.wechat.common.utils.MenuUtil;
import com.wechat.common.utils.MessageUtil;
import com.wechat.message.pojo.Message;
import com.wechat.message.pojo.article.Article;
import com.wechat.message.pojo.article.ArticleMessage;
import com.wechat.message.pojo.image.Image;
import com.wechat.message.pojo.image.ImageMessage;
import com.wechat.message.pojo.text.TextMessage;
import com.wechat.message.service.IMessageService;

/**
 * @ file_name MessageServiceTest.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月11日下午1:53:53
 * @ description
 * @ reviewed_by 
 */
@ContextConfiguration(locations={"classpath:application-context-jdbc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageServiceTest {
	
	@Resource(name="messageService")
	private IMessageService messageService;
	
	@Test
	public void testService(){
		org.junit.Assert.assertNotNull(messageService);
	}
	
	
	/*@Test
	public void testTextMessageSave() throws WechatEcxeption{
		TextMessage textMessage = new TextMessage();
		//要注意null值所对应的属性，是不转化为xml里面的标签的
		textMessage.setContent("这个是测试的温灸养生里面的内容");
		textMessage.setMessageType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
		messageService.saveMessage(textMessage);
	}
	@Test
	public void testImageMessageSave() throws WechatEcxeption{
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setMessageType(MessageUtil.REQ_MESSAGE_TYPE_IMAGE);
		Image image = new Image();
		image.setMediaId("232332");
		image.setPicUrl("http://233232/sds");
		imageMessage.setImage(image);
		messageService.saveMessage(imageMessage);
	}
	@Test
	public void testNewMessageSave() throws WechatEcxeption{
		ArticleMessage message = new ArticleMessage();
		message.setMessageType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		List<Article> articles = new ArrayList<Article>();
		Article article = new Article();
		article.setArticleDescription("当我朝着反方向走去，在楼梯的角落找勇气，曾经并肩往前的伙伴，沉默着懂得我的委屈，时间她总说谎，我从不曾失去那些肩膀");
		article.setArticleTitle("明天，你好");
		article.setArticleUrl("#");
		article.setArticlePicUrl(ConnectWechatUtil.APP_CONTEXT_IMAGE_URL+"food.jpg");
		articles.add(article);
		message.setArticles(articles);
		message.setArticleCount(articles.size());
		messageService.saveMessage(message);
	}
//	@Test
//	public void textFindByMenuCode() {
//		Message message = messageService.findMessageByMenu("3");
//		TextMessage tm = (TextMessage)message;
//		System.out.println(tm.getContent());
//	}
	

*/}
