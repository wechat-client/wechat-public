package com.wechat.menu;

import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JsonConfig;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wechat.message.pojo.article.Article;
import com.wechat.message.pojo.article.ArticleMessage;
import com.wechat.message.pojo.image.Image;
import com.wechat.message.pojo.image.ImageMessage;
import com.wechat.message.pojo.text.TextMessage;

public class XStreamTest {


    private static XStream xstream = new XStream(new XppDriver() {  
        public HierarchicalStreamWriter createWriter(Writer out) {  
            return new PrettyPrintWriter(out) {  
                // 对所有xml节点的转换都增加CDATA标记  
                boolean cdata = true;  
  
                @SuppressWarnings("unchecked")  
                public void startNode(String name, Class clazz) { 
                
                    super.startNode(name, clazz);  
                }  
  
                protected void writeText(QuickWriter writer, String text) {  
                    if (cdata) {  
                        writer.write("<![CDATA[");  
                        writer.write(text);  
                        writer.write("]]>");  
                    } else {  
                        writer.write(text);  
                    }  
                }  
            };  
        }  
    });  
	
	@Test
	public void testTextMessage(){
		
		TextMessage textMessage = new TextMessage();
		textMessage.setMessageId(1);
		//要注意null值所对应的属性，是不转化为xml里面的标签的
		textMessage.setContent(null);
		textMessage.setMessageCreateTime(String.valueOf(new Date().getTime()));
		textMessage.setMessageFromUser("feifei");
		textMessage.setMessageToUser("sence");
		textMessage.setMessageType("text");
		textMessage.setMsgId("2323");
		textMessage.setTextMessageId(234);
		//对指定的类使用Annotation
        xstream.processAnnotations(TextMessage.class);
        //启用Annotation
        xstream.autodetectAnnotations(true);
		String str = xstream.toXML(textMessage);
		
		System.out.println(str);
		
	}
	
	@Test
	public void testArticleMessage(){
		
		Article article1 = new Article();
		article1.setArticleId(1);
		article1.setArticleDescription("图文消息的描述1");
		article1.setArticlePicUrl("http://article1.pic.url.com");
		article1.setArticleTitle("图文消息1");
		article1.setArticleUrl("http://article1.url.com");
		article1.setMessageId(1);
		
		Article article2 = new Article();
		article2.setArticleId(2);
		article2.setArticleDescription("图文消息的描述2");
		article2.setArticlePicUrl("http://article2.pic.url.com");
		article2.setArticleTitle("图文消息2");
		article2.setArticleUrl("http://article2.url.com");
		article2.setMessageId(1);
		
		Article article3 = new Article();
		article3.setArticleId(3);
		article3.setArticleDescription("图文消息的描述3");
		article3.setArticlePicUrl("http://article3.pic.url.com");
		article3.setArticleTitle("图文消息3");
		article3.setArticleUrl("http://article3.url.com");
		article3.setMessageId(1);
		
		List<Article> articles = new ArrayList<Article>();
		articles.add(article1);
		articles.add(article2);
		articles.add(article3);
		
		ArticleMessage am = new ArticleMessage();
		am.setMessageId(1);
		am.setMessageCreateTime(String.valueOf(new Date().getTime()));
		am.setMessageFromUser("feifei");
		am.setMessageToUser("sence");
		am.setMessageType("news");
		am.setArticleCount(3);
		am.setArticles(articles);
		
		xstream.processAnnotations(ArticleMessage.class);
		xstream.autodetectAnnotations(true);
		
		String xml = xstream.toXML(am);
		System.out.println(xml);
	}
	
	@Test
	public void testImageMessage(){
		
		Image image = new Image();
		image.setMediaId("1");
		image.setMsgId("32");
		image.setPicUrl("http://pic.url.com");
		
		ImageMessage im = new ImageMessage();
		im.setMessageId(1);
		im.setMessageCreateTime(String.valueOf(new Date().getTime()));
		im.setMessageFromUser("feifei");
		im.setMessageToUser("sence");
		im.setMessageType("image");
		im.setImage(image);
		
		xstream.processAnnotations(Image.class);
		xstream.autodetectAnnotations(true);
		
		String xml = xstream.toXML(im);
		System.out.println(xml);
		
		JsonConfig jc = new JsonConfig();
		
	}
	
}
