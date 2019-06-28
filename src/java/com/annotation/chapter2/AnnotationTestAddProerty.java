package com.annotation.chapter2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
public @interface AnnotationTestAddProerty {
	//定义属性的语法  :
	//有默认值：类型  属性名() defalut 默认值;
	//无默认值：类型  属性名();
	String  addPropery();
	String  defaultPropery() default "你好";
}
//