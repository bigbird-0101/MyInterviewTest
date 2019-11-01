package com.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		ThreadPoolExecutor es=(ThreadPoolExecutor)testThreadPoolKeepALiveTime();
		int activeCount=-1;
		int queueSize=-1;
		while(true) {
			if(activeCount!=es.getActiveCount()||queueSize!=es.getQueue().size()) {
				System.out.println("getActiveCount : "+es.getActiveCount());
				System.out.println("getPoolSize : "+es.getPoolSize());
				System.out.println("getQueue : "+es.getQueue().size());
				System.out.println("getMaximumPoolSize : "+es.getMaximumPoolSize());
				activeCount=es.getActiveCount();
				queueSize=es.getQueue().size();
				System.out.println("=============");
			}
		}
	}
	public static ExecutorService testThreadPool() {
		ExecutorService es=new ThreadPoolExecutor(2, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2));
		IntStream.range(0, 10)
		.boxed()
		.forEach(i->{
			es.submit(()->System.out.println(Thread.currentThread().getName()+"a"+i));
		});
		return es;
	}
	public static ExecutorService testSingleThreadPool() {
		ExecutorService es=Executors.newSingleThreadExecutor();
		IntStream.range(0, 10)
		.boxed()
		.forEach(i->{
			es.submit(()->System.out.println(Thread.currentThread().getName()+"a"+i));
		});
		return es;
	}
	public static ExecutorService testFixedThreadPool() {
		ExecutorService es=Executors.newFixedThreadPool(5);
		IntStream.range(0, 10)
		.boxed()
		.forEach(i->{
			es.submit(()->System.out.println(Thread.currentThread().getName()+"a"+i));
		});
		return es;
	}
	
	public static ThreadPoolExecutor testThreadPoolKeepALiveTime() {
		ThreadPoolExecutor es=new ThreadPoolExecutor(8,10,5L,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(2));
		System.out.println(es.getTaskCount());
		es.allowCoreThreadTimeOut(true);
		IntStream.range(0, 12)
		.boxed()
		.forEach(i->{
			es.submit(()->{
				try {
					TimeUnit.SECONDS.sleep(3);
//					System.out.println(Thread.currentThread().getName()+"a"+i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		});
		return es;
	}
}
//                           