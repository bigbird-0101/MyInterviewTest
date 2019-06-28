package com.annotation.chapter2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//添加复杂属性的注解测试
@Retention(RetentionPolicy.RUNTIME)
//@Target 默认是所有的值
public @interface AnnotationAddComplexPropery {
	//可以添加不同类型的属性
	int[] arrayAttr() default {1,2,4};
	String[] addComplexAttr();
	MyEnum addEnumAttr();
}
//                                                                                                                           