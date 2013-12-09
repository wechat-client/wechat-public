package com.wechat.common.utils.json;

import java.lang.reflect.Field;

import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;


public abstract class AbstaractFieldFilter implements PropertyFilter {

	private JSONAliasProcessor processor;
	
	private JsonConfig config;
	
	public AbstaractFieldFilter(JsonConfig config,JSONAliasProcessor processor){
		this.config = config;
		this.processor = processor;
	}
	
	public abstract boolean apply(Field field);
	
	/**完成注册field 所属的clazz*/
	@Override
	public boolean apply(Object source, String name, Object value) {
		
		Class clazz = source.getClass();
		Field field = null;
		try {
			field = clazz.getDeclaredField(name);
			field.setAccessible(true);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			//如果是NoSuchFieldException，则说明可能在父类里面
			field = getSuperField(clazz,name);
		}
		return apply(field);
		
	}

	private Field getSuperField(Class clazz, String name) {
		Field field = null;
		for (; !clazz.equals(Object.class); clazz = clazz.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(name);
				field.setAccessible(true);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				continue;
			}
			
		}
		return field;
		
	}

	public JSONAliasProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(JSONAliasProcessor processor) {
		this.processor = processor;
	}

	public JsonConfig getConfig() {
		return config;
	}

	public void setConfig(JsonConfig config) {
		this.config = config;
	}
	
	

}
