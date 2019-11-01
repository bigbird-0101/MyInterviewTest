package com.mianshi.bitoperation;

/**
 * java 位运算深入解析
 * 在执行以上位移操作时，由于计算机中使用补码存储数字，
 * 对于正数来说，补码等于原码，所以直接进行相应的左移或者右移操作，
 * 对于负数来说，补码等于原码按位取反后，末位加1，且最高位为符号位。这时进行位移操作，当右移时高位补充符号位即补1，左移时低位补0。
 * @author corget
 *
 */
public class BitOperation {
	
	/**
	 * 负数左移
	 * 2<<2  左移两位
	 * 10 左移两位  不能省掉高位,否则导致结果溢出异常，低位补0
	 * 所以正确的结果是 1000
	 * @param param 位数
	 */
	public static void toLeftNegativeNumber(int param,int count) {
		int result=param<<count;
		System.out.println(Integer.toBinaryString(result));
	}
	
	/**
	 * 正数左移
	 * 2<<2  左移两位
	 * 10 左移两位  不能省掉高位,否则导致结果溢出异常，低位补0
	 * 所以正确的结果是 1000
	 * @param param 位数
	 */
	public static void toLeftPositiveNumber(int param,int count) {
		int result=param<<count;
		System.out.println(Integer.toBinaryString(result));
	}
	
	/**
	 * 将一个int数字转换为二进制的字符串形式。
	 * @param num 需要转换的int类型数据
	 * @param digits 要转换的二进制位数，位数不足则在前面补0
	 * @return 二进制的字符串形式
	 */
	public static String toBinary(int num, int digits) {
	    int value = ((1 << digits)-1) & num;
	    String bs = Integer.toBinaryString(value); //0x20 | 这个是为了保证这个string长度是6位数
	    return  bs;
	}
	
	public static void main(String[] args) {
		toLeftNegativeNumber(-1,2);
		
//		System.out.println(toBinary(2,4));
//		System.out.println(Integer.toBinaryString(2));
	}
}

//   