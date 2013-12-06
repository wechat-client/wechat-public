package com.wechat.common.utils.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface JSONAlias {

	/**
	 * The name of the class or field alias.
	 */
	public String name();

}
