package com.wechat.common.utils.json;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JSONPropertyHandlerFilter extends AbstaractFieldFilter {

	private JSONAliasProcessor processor;

	public JSONPropertyHandlerFilter(final JSONAliasProcessor processor,
			JsonConfig config) {
		super(config);
		this.processor = processor;

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

	public JSONAliasProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(JSONAliasProcessor processor) {
		this.processor = processor;
	}

	private boolean isPrimitiveType(Class clazz) {
		if (clazz == Boolean.TYPE)
			return true;
		if (clazz == Short.TYPE)
			return true;
		if (clazz == Integer.TYPE)
			return true;
		if (clazz == Float.TYPE)
			return true;
		if (clazz == Double.TYPE)
			return true;
		if (clazz == Byte.TYPE)
			return true;
		if (clazz == Character.TYPE)
			return true;
		if (clazz == Long.TYPE)
			return true;
		return false;
	}

	private boolean isMapType(Class clazz) {

		return false;
	}

	private boolean isCollectionType(Class clazz) {
		return false;
	}
}
