package com.mianshi;

/**
 * 时间:2019年2月13日
 * 
 * @author pefuxc
 *
 */
public class TestValueOrYinyong {
	String str = new String("hello");
	char[] ch = { 'a', 'b' };

	public static void main(String[] args) {
		TestValueOrYinyong ex = new TestValueOrYinyong();
		ex.change(ex.str, ex.ch);
		System.out.println(ex.str + " and");
		System.out.println(ex.ch);
	}

	public void change(String str, char[] ch) {
		str = new String("ok");
		ch[0] = 'c';
	}
}

class Test3 {
	 public static void main(String[] args) {
		Integer var1 = new Integer(1000);
		Integer var2 = var1;
		Float a=1.0f;
		float b=1.0f;
		dosomeing(var2,var1);
		System.out.println(var1.intValue());
		System.out.println(var1 == var2);
	}
	private static void dosomeing(Integer var2, Integer var1) {
		var2 = new Integer(2000);
		var1=var2;
	}
	enum A{
		a;
		private A(){
			
		}
	}
}