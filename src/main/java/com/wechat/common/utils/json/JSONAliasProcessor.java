package com.wechat.common.utils.json;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;
import net.sf.json.processors.JsonValueProcessor;

public class JSONAliasProcessor implements JsonBeanProcessor{

	
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
	public JSONObject processBean(Object arg0, JsonConfig arg1) {
		
		return null;
	}

	private Object process(Object value, JsonConfig jsonConfig) {
		if (value == null) {
            return null;
        }
        String ret = null;
        
        reset();                             // 处理后重置，以免影响其他 Integer 属性

        return ret;
		
		
	}

	
	
}
