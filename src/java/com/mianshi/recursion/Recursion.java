package com.mianshi.recursion;

public class Recursion {

	public static void main(String[] args) {
		help(1);
	}

	private static void help(int i) {
		System.out.println(i);
		if(i==1000) {
			return;
		}
		help(++i);
	}
}
