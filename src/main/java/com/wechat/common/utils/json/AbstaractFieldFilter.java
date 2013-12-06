package com.wechat.common.utils.json;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.activation.FileDataSource;

import net.sf.json.util.PropertyFilter;


public abstract class AbstaractFieldFilter implements PropertyFilter {

	public abstract boolean apply(Field field);
	
	@Override
	public boolean apply(Object source, String name, Object value) {
		
		Class clazz = source.getClass();
		Field field = null;
		try {
			field = clazz.getField(name);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return apply(field);
		
	}

}
