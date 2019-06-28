package com.annotation.chapter2;
@TestDefaultAnnotation
public class DefaultAnnotationTest {
	@TestDefaultAnnotation
	public static void main(@TestDefaultAnnotation String[] args) {
		if(DefaultAnnotationTest.class.isAnnotationPresent(TestDefaultAnnotation.class)) {
			TestDefaultAnnotation tda=DefaultAnnotationTest.class.getAnnotation(TestDefaultAnnotation.class);
			System.out.println(tda.value());//没有结果说明默认不是在runtime的范围
		}
	}
}
//