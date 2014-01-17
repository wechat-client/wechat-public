package com.wechat.common.utils;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.MarshallingStrategy;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.DataHolder;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.mapper.Mapper;
import com.wechat.message.pojo.Message;
import com.wechat.message.pojo.image.ImageMessage;
import com.wechat.message.pojo.music.MusicMessage;
import com.wechat.message.pojo.text.TextMessage;
import com.wechat.message.pojo.vedio.VedioMessage;
import com.wechat.message.pojo.voice.VoiceMessage;
import com.wechat.message.pojo.article.Article;
import com.wechat.message.pojo.article.ArticleMessage;

public class MessageUtil {

	/** 
     * 返回消息类型：文本 
     */  
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * 返回消息类型：音乐 
     */  
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";  
  
    /** 
     * 返回消息类型：图文 
     */  
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";  
  
    /** 
     * 请求消息类型：文本 
     */  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  

    /** 
     * 请求消息类型：图片 
     */  
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";  
  
    /** 
     * 请求消息类型：链接 
     */  
    public static final String REQ_MESSAGE_TYPE_LINK = "link";  
  
    /** 
     * 请求消息类型：地理位置 
     */  
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";  
  
    /** 
     * 请求消息类型：音频 
     */  
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";  
    
    /**
     * 请求消息类型：视频
     */
    public static final String REQ_MESSAGE_TYPE_VEDIO = "vedio";  
    
    /** 
     * 请求消息类型：推送 
     */  
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  
  
    /** 
     * 事件类型：subscribe(订阅) 
     */  
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  
  
    /** 
     * 事件类型：unsubscribe(取消订阅) 
     */  
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  
    
    /** 
     * 事件类型：地理位置
     */  
    public static final String EVENT_TYPE_LOCATION = "LOCATION"; 
    
    /** 
     * 事件类型：CLICK(自定义菜单点击事件) 
     */  
    public static final String EVENT_TYPE_CLICK = "CLICK";  
    /** 
     * 事件类型：扫描二维码关注事件
     */  
    public static final String EVENT_TYPE_SCAN_SUBSCRIBE = "scansubscribe";  
    /** 
     * 事件类型：扫描二维码事件
     */  
    public static final String EVENT_TYPE_SCAN = "scan";  
    
   
    /** 
     * 解析微信发来的请求（XML） 
     *  
     * @param request 
     * @return 
     * @throws Exception 
     */  
    @SuppressWarnings("unchecked")  
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {  
        // 将解析结果存储在HashMap中  
        Map<String, String> map = new HashMap<String, String>();  
        // 从request中取得输入流  
        InputStream inputStream = request.getInputStream();  
        // 读取输入流  
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);  
        // 得到xml根元素  
        Element root = document.getRootElement(); 
        // 得到根元素的所有子节点  
        List<Element> elementList = root.elements();  
        
        // 遍历所有子节点  
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  
  
        // 释放资源  
        inputStream.close();  
        inputStream = null;  
  
        return map;  
    }  
  
    /** 
     * 文本消息对象转换成xml 
     *  
     * @param textMessage 文本消息对象 
     * @return xml 
     */  
    public static String messageToXml(Message message) {  
    	xstream.autodetectAnnotations(true);
        if(message instanceof TextMessage){
        	xstream.processAnnotations(TextMessage.class);
        	TextMessage tm = (TextMessage)message;
        	return xstream.toXML(tm);  
        }
        if(message instanceof MusicMessage){
        	xstream.processAnnotations(MusicMessage.class);
        	MusicMessage mm = (MusicMessage)message;
        	return xstream.toXML(mm);  
        }
        if(message instanceof ArticleMessage){
        	xstream.processAnnotations(ArticleMessage.class);
        	ArticleMessage am = (ArticleMessage)message;
        	return xstream.toXML(am);  
        }
        if(message instanceof VedioMessage){
        	xstream.processAnnotations(VedioMessage.class);
        	VedioMessage vm = (VedioMessage)message;
        	return xstream.toXML(vm);  
        }
        if(message instanceof VoiceMessage){
        	xstream.processAnnotations(VoiceMessage.class);
        	VoiceMessage vm = (VoiceMessage)message;
        	return xstream.toXML(vm);  
        }
        if(message instanceof ImageMessage){
        	xstream.processAnnotations(ImageMessage.class);
        	ImageMessage im = (ImageMessage)message;
        	return xstream.toXML(im);  
        }
     	
        return null;
        
    }  

    /** 
     * 扩展xstream，使其支持CDATA块 
     *  
     * @date 2013-05-19 
     */  
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
}
