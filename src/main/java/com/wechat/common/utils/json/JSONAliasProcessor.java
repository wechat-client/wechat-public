package com.wechat.common.utils.json;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JSONAliasProcessor implements JsonValueProcessor{

	
	private String fieldAlias;
	
	
	private void reset(){
		fieldAlias = null;
	}
	
	public String getFieldAlias() {
		return fieldAlias;
	}

	public void setFieldAlias(String fieldAlias) {
		this.fieldAlias = fieldAlias;
	}

	@Override
	public Object processArrayValue(Object value, JsonConfig config) {
		return null;
	}

	@Override
	public Object processObjectValue(String key, Object value, JsonConfig config) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
