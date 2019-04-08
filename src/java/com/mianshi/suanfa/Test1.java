package com.mianshi.suanfa;
/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 时间:2019年2月15日
 * @author pefuxc
 *
 */
public class Test1 {
    public static String replaceSpace(StringBuffer str) {
    	String result="";
    	String aData=str.toString();
    	result=aData.replaceAll("\\s+", "%20");
		return result;
    }
    public static void main(String[] args) {
		StringBuffer aStringBuffer=new StringBuffer("We Are Happy");
		System.out.println(replaceSpace2(aStringBuffer));
	}
    public static String replaceSpace2(StringBuffer str) {
    	String result="";
    	String aData=str.toString();
    	char[] array=aData.toCharArray();
        //空格的个数
        for (int i = 0; i < array.length; i++) {
			if(array[i]==' '){
				//扩容的备用数组
				char[] array2=null;
				//每次有一次得到空字符，就要在原来的数组基础之上扩容2个字段  而且索引得加2
				array2=new char[array.length+2];
			    //字段扩容机制
			    System.arraycopy(array, 0, array2, 0, array.length);
				array2[i]='%';
				array2[i+1]='2';
				array2[i+2]='0';
				//将后面的还未识别的添加到备用数组中
				System.arraycopy(array, i+1, array2, i+3, array.length-i-1);
				array=array2;
				i=i+2;
				array2=null;
			}
		}
        result=new String(array);
        return result;
    }
}
