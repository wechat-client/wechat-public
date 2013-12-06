package com.wechat.common.utils.json;

import java.lang.reflect.Field;

public class JSONOmitFilter extends AbstaractFieldFilter{

	@Override
	public boolean apply(Field field) {
		//有JSONOmitField
		if(field.isAnnotationPresent(JSONOmitField.class))return true;
		return false;
	}

}
