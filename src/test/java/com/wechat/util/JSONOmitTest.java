package com.wechat.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.junit.Test;

import com.wechat.common.utils.json.AnnotationObjectToJSON;
import com.wechat.common.utils.json.JSONPropertyHandlerFilter;
import com.wechat.common.utils.json.JSONAliasProcessor;
import com.wechat.menu.pojo.Menu;
import com.wechat.message.pojo.image.Image;
import com.wechat.message.pojo.image.ImageMessage;
import com.wechat.message.pojo.text.TextMessage;


public class JSONOmitTest {

	@Test
	public void testOmitMenu(){
		Menu menu1 = new Menu();
		menu1.setAppId(1);
		menu1.setKey(null);
		menu1.setMenuId(1);
		menu1.setName("menu1");
		menu1.setParentId(0);
		menu1.setType(null);
		menu1.setUrl(null);
		menu1.setUserId(1);
		
		Menu menu2 = new Menu();
		menu2.setAppId(1);
		menu2.setKey(null);
		menu2.setMenuId(2);
		menu2.setName("menu2");
		menu2.setParentId(0);
		menu2.setType(null);
		menu2.setUrl(null);
		menu2.setUserId(1);
		
		
		Menu menu3 = new Menu();
		menu3.setAppId(1);
		menu3.setKey("menu3_3");
		menu3.setMenuId(3);
		menu3.setName("menu3");
		menu3.setParentId(1);
		menu3.setType("click");
		menu3.setUrl(null);
		menu3.setUserId(1);
		
		Menu menu5 = new Menu();
		menu5.setAppId(1);
		menu5.setKey(null);
		menu5.setMenuId(3);
		menu5.setName("menu5");
		menu5.setParentId(1);
		menu5.setType("view");
		menu5.setUrl("www.menu5.com");
		menu5.setUserId(1);
		
		Menu menu4 = new Menu();
		menu4.setAppId(4);
		menu4.setKey("menu4_4");
		menu4.setMenuId(4);
		menu4.setName("menu4");
		menu4.setParentId(2);
		menu4.setType("click");
		menu4.setUrl(null);
		menu4.setUserId(1);
		
		List<Menu> menus = new ArrayList<Menu>();
		menus.add(menu3);
		menus.add(menu5);
		menu1.setSub_button(menus);
		List<Menu> menus2 = new ArrayList<Menu>();
		menus2.add(menu4);
		menu2.setSub_button(menus2);
		
		List<Menu> tmenus = new ArrayList<Menu>();
		tmenus.add(menu1);
		tmenus.add(menu2);
		AnnotationObjectToJSON aot = new AnnotationObjectToJSON(Menu.class);
		String json = aot.toJSONString(tmenus);
		JSONObject jo = new JSONObject();
		jo.put("button", json);
		//System.out.println(jo.toString());
	}
	
	@Test
	public void testTextMessage(){
		TextMessage textMessage = new TextMessage();
		textMessage.setMessageId(1);
		//要注意null值所对应的属性，是不转化为xml里面的标签的
		textMessage.setContent("32343434");
		textMessage.setMessageCreateTime(String.valueOf(new Date().getTime()));
		textMessage.setMessageFromUser("feifei");
		textMessage.setMessageToUser("sence");
		textMessage.setMessageType("text");
		textMessage.setMsgId("2323");
		textMessage.setTextMessageId(234);
		
		AnnotationObjectToJSON aot = new AnnotationObjectToJSON(TextMessage.class);
		//System.out.println(aot.toJSONString(textMessage));
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
		
		AnnotationObjectToJSON aot = new AnnotationObjectToJSON(new Class[]{Image.class,ImageMessage.class});
		//System.out.println(aot.toJSONString(im));
	}
	
}
