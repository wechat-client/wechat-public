package com.wechat.common.utils.json;

import java.lang.reflect.Field;

public class JSONAliasFilter extends AbstaractFieldFilter{

	
	private JSONAliasProcessor processor;
	
	 public JSONAliasFilter(final JSONAliasProcessor processor) {
	        this.processor = processor;
	    }
	
	@Override
	public boolean apply(Field field) {
		if(field.isAnnotationPresent(JSONAlias.class)){
			JSONAlias alias = field.getAnnotation(JSONAlias.class);
			String name = alias.name();
			if(name!=null){
				 processor.setFieldAlias(name);      
			}
		}
		return false;
	}

}
