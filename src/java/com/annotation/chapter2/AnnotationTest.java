package com.annotation.chapter2;

@AnnotationTestAddProerty(addPropery = "添加属性测试")
public class AnnotationTest {
	
	public static void main(String[] args) {
		//反射判断是否被@AnnotationTestAddProerty注解修改
		if(AnnotationTest.class.isAnnotationPresent(AnnotationTestAddProerty.class)){
			//那么怎么获得注解这个对象呢
			AnnotationTestAddProerty aAnnotation=AnnotationTest.class.getAnnotation(AnnotationTestAddProerty.class);
			String avalue=aAnnotation.addPropery();//得到该属性值了  添加属性测试
			String property=aAnnotation.defaultPropery();//也可以得到默认设置的属性值
			System.out.println("addPropery:"+avalue+" defaultPropery:"+property);
		}
	}
}
//