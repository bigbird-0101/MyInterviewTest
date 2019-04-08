package com.mianshi;
/**
 * ʱ��:2019��2��13��
 * @author pefuxc
 *
 */
public class StaticMianShi {

//	public static final String a="JD";
//	static{
//		System.out.println("static");
//	}
	public static void main(String[] args) {
		System.out.println(Test2.a);
	}
}

class Test{
	public static final String a="JDTest";
	static{
		System.out.println("staticTest");
	}
}

class Test2{
	public static final String a=new String("JDTest2");
	static{
		System.out.println("staticTest2");
	}
}