package com.collection.arraylist;

import java.util.Comparator;
import java.util.List;

/**
 * 针对不容类型的list进行排序
 * @author corget
 */
public class ArrayListSort {
	public static void main(String[] args) {
		System.out.println(1<<8|2);
		/*ArrayList aList=new ArrayList();
        aList.add("a");
        aList.add("1");
        aList.add("a");
        aList.add("A");
        aList.add("A");
        aList.add("你好");
        listSort(aList);
        System.out.println(aList.toString());*/
	}
	
	/**
	 * 采用本身list.sort()进行排序
	 */
	public static void listSort(List aList) {
		aList.sort(new ArrayListSort().new Sort());
	}
	private class Sort implements Comparator<Object>{

		@Override
		public int compare(Object o1, Object o2) {
			String aString=(String)o1;
			String aString2=(String)o2;
			int a=aString.compareTo(aString2);
			if(a>0) {
				return 1;
			}else if(a<0){
				return -1;
			}else {
				return 0;
			}
		}
	}
}
//                                                                                      