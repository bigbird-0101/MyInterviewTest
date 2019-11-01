package com.concurrent;

import java.util.concurrent.TimeUnit;

import com.mysql.cj.util.TimeUtil;

/**
 * @author corget
 *
 */
public class Test2 {
   public static void main(String[] args) throws InterruptedException {
	  new Thread(()->{
		try {
			System.out.println(Thread.currentThread().getName());
			TimeUnit.SECONDS.sleep(1);
			System.out.println("over....");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }).start();
	   Thread.currentThread().join();
	   System.out.println(Thread.currentThread().getName());
   }
}
//