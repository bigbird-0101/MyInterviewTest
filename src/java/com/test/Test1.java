package com.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("dd");
		getString();
		System.out.println("2");
	}
	public static String getString() {
		ExecutorService es=Executors.newSingleThreadExecutor();
		es.submit(()->{try {
			TimeUnit.SECONDS.sleep(10);
			System.out.println("a");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		es.shutdown();
		return "";
	}
}
//                                       