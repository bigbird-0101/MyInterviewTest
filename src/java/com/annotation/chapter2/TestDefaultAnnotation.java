package com.annotation.chapter2;
//一个空的默认的注解  不加元注解的  默认不是runtime  
//默认注解在哪里都可以使用，但是使用范围不是runtime

public @interface TestDefaultAnnotation {

	String value() default "1";
}
//