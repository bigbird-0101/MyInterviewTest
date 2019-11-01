package com.collection.skip;

import java.time.LocalDateTime;
import java.time.temporal.IsoFields;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 
 * @author corget
 *
 */
public class ConcurrentSkipListTest {
	
	public static void main(String[] args) {
	     testAdd();	
	}

	private static void testAdd() {
         ConcurrentSkipListMap<String, String> a=new ConcurrentSkipListMap<>();
         a.put("a", "b");
         for (int i = 0; i <10000000; i++) {
			a.put("a"+i, "b"+i);
		 }
         long dd=LocalDateTime.now().getSecond();
         System.out.println(dd);
         a.get("a10000");
         System.out.println(LocalDateTime.now().getSecond()-dd);

	}
}
//                      