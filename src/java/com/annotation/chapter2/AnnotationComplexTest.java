package com.annotation.chapter2;

@AnnotationAddComplexPropery(addComplexAttr = { "你好" }, addEnumAttr = MyEnum.A)
public class AnnotationComplexTest {
	@AnnotationAddComplexPropery(addComplexAttr = { "你好" }, addEnumAttr = MyEnum.A)
	public static void main(@AnnotationAddComplexPropery(addComplexAttr = { "你好" }, addEnumAttr = MyEnum.A)String[] args) {
		//获取设置的属性值
		if(AnnotationComplexTest.class.isAnnotationPresent(AnnotationAddComplexPropery.class)) {
			AnnotationAddComplexPropery aacp=AnnotationComplexTest.class.getAnnotation(AnnotationAddComplexPropery.class);
			String[] aStrings=aacp.addComplexAttr();
			MyEnum enum1=aacp.addEnumAttr();
			int[] ints=aacp.arrayAttr();
			System.out.println("String[]:"+aStrings+"  MyEnum:"+enum1.toString()+"  int[]"+ints.toString());
		}
	}
}
//