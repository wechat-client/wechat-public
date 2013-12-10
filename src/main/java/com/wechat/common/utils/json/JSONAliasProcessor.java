package com.wechat.common.utils.json;

import net.sf.json.processors.PropertyNameProcessor;

public class JSONAliasProcessor implements PropertyNameProcessor{

	
	private String fieldAlias;
	private String fieldName;
	
	public String getFieldAlias() {
		return fieldAlias;
	}

	public void setFieldAlias(String fieldAlias) {
		this.fieldAlias = fieldAlias;
	}
	
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public String processPropertyName(Class clazz, String name) {
		
		if(name.equals(fieldName)) return fieldAlias;
		return name;
	
	}

	
	
	
}

