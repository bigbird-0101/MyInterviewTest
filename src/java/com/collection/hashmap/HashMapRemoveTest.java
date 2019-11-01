package com.collection.hashmap;

import java.util.HashMap;

public class HashMapRemoveTest {

	public static void main(String[] args) {

		HashMap a=new HashMap(1);
		a.put("1", 2);
		a.forEach((c,d)->System.out.println(c+""+d));
		a.remove("1");
		a.forEach((c,d)->System.out.println(c+""+d));
        System.out.println(a);
	}
}
//