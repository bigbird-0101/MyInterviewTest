package com.jihe;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * ʱ��:2019��2��21��
 * 
 * @author pefuxc
 *
 */
public class Test {
	static final int MAXIMUM_CAPACITY = 1 << 30;

	public static void main(String[] args){
		System.out.println(MAXIMUM_CAPACITY);
		System.out.println(-1 >>> 1);
		System.out.println(tableSizeFor(5));
		erjinzhi(2147483647);
		HashMap<String, String> aHashMap = new HashMap<String, String>(4);
		Class aClass = aHashMap.getClass();
		Field[] aFields = aClass.getDeclaredFields();
		for (Field field : aFields) {
			field.setAccessible(true);
			if (field.getName().equals("threshold")) {
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if(field.getName().equals("table")){
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if(field.getName().equals("size")){
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			field.setAccessible(false);
		}
		System.out.println();
		aHashMap.put("1", "1");
		for (Field field : aFields) {
			field.setAccessible(true);
			if (field.getName().equals("threshold")) {
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if(field.getName().equals("table")){
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if(field.getName().equals("size")){
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			field.setAccessible(false);
		}
		System.out.println();
		aHashMap.put("2", "1");
		for (Field field : aFields) {
			field.setAccessible(true);
			if (field.getName().equals("threshold")) {
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if(field.getName().equals("table")){
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if(field.getName().equals("size")){
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			field.setAccessible(false);
		}
		System.out.println();
		aHashMap.put("3", "1");
		for (Field field : aFields) {
			field.setAccessible(true);
			if (field.getName().equals("threshold")) {
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if(field.getName().equals("table")){
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if(field.getName().equals("size")){
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			field.setAccessible(false);
		}
		System.out.println();
		aHashMap.put("4", "1");
//		aHashMap.put("5", "1");
//		aHashMap.put("6", "1");
//		aHashMap.put("7", "1");
		for (Field field : aFields) {
			field.setAccessible(true);
			if (field.getName().equals("threshold")) {
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if(field.getName().equals("table")){
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if(field.getName().equals("size")){
				try {
					System.out.println("�ֶ���Ϊ��������" + field.getName() + "�ֶ�ֵΪ������"
							+ field.get(aHashMap));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			field.setAccessible(false);
		}
		System.out.println(aHashMap.size());
		String a = new String("ab");
		a.substring(0, 1);
		System.out.println(a.hashCode());
	}

	/**
	 * Returns a power of two size for the given target capacity.
	 */
	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}

	static void erjinzhi(int param) {

		for (int i = 0; i < 32; i++) {

			int t = (param & 0x80000000 >>> i) >>> (31 - i);

			System.out.print(t);

		}
		System.out.println();
	}
}
