package com.wechat.common.utils.json;

import java.lang.reflect.Field;

import net.sf.json.JsonConfig;

public class JSONPropertyHandlerFilter extends AbstaractFieldFilter{

	
	
	
	public JSONPropertyHandlerFilter(final JSONAliasProcessor processor,JsonConfig config) {
			super(config,processor);
	       
	}
	
	@Override
	public boolean apply(Field field) {
		//如果标注了JSONOmitField 忽略该属性
		if(field.isAnnotationPresent(JSONOmitField.class))return true;
		//如果设置了JsonAlias 则别称该属性
		if(field.isAnnotationPresent(JSONAlias.class)){
			JSONAlias alias = field.getAnnotation(JSONAlias.class);
			String aliasName = alias.value();
			String fieldName = field.getName();
			if(aliasName!=null){
				 getProcessor().setFieldAlias(aliasName);  
				 getProcessor().setFieldName(fieldName);
			}
		}
		
		return false;
	}

}
