package com.jdk8newfeatures.comfuture;

import java.util.concurrent.CompletableFuture;

import com.alibaba.fastjson.JSONArray;

public class CompletableFutureAPITest {
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		supplyAsync().join();
		System.out.println("a");
//		Thread.currentThread().join();
	}
	/**
	 * @return
	 */
	public static CompletableFuture supplyAsync() {
		return CompletableFuture.supplyAsync(CompletableFutureAPITest::getString).thenAcceptAsync(s->{
			JSONArray jsonArray=(JSONArray) JSONArray.parse(s);
			jsonArray.forEach(System.out::println);
			});
	}
	public static String getString() {
		return "[\"corget\",\"0d615c64a58986febf85f7fde3f509bade3e365b\",\"corget\",\"00000000000\",\"china\",\"福建省\",\"泉州市\"]";
	}
}
//