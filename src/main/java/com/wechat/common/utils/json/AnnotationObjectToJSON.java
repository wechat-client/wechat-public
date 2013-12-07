package com.wechat.common.utils.json;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

public class AnnotationObjectToJSON {
	
	private JsonConfig config;
	
	public AnnotationObjectToJSON(Class[] targetClass) {
		JSONAliasProcessor processor = new JSONAliasProcessor();
		JSONPropertyHandlerFilter handlerFilter = new JSONPropertyHandlerFilter(processor,config);
		config = new JsonConfig();
		config.setJsonPropertyFilter(handlerFilter);
		for(Class clazz:targetClass){
			config.registerJsonPropertyNameProcessor(clazz, processor);
		}
		
		
	}
	public AnnotationObjectToJSON(Class targetClass) {
		JSONAliasProcessor processor = new JSONAliasProcessor();
		JSONPropertyHandlerFilter handlerFilter = new JSONPropertyHandlerFilter(processor,config);
		config = new JsonConfig();
		config.setJsonPropertyFilter(handlerFilter);
		config.registerJsonPropertyNameProcessor(targetClass, processor);
		
	}
//	
//	private void registerJsonPropertyNameProcessores(Class targetClass,JSONAliasProcessor processor) {
//		
//		config.registerJsonPropertyNameProcessor(targetClass, processor);
//		for(targetClass)
//		
//	}


	public String toJSONString(Object object){
		
		JSON json = JSONSerializer.toJSON(object, config);
		return json.toString();
		
	}
	
}
