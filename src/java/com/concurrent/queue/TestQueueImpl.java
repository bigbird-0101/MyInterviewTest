package com.concurrent.queue;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TestQueueImpl {

	public static void main(String[] args) throws InterruptedException {
//		Queue<String> q=testSyncQueue();
//		SynchronousQueue qa=(SynchronousQueue)q;
//		System.out.println(qa.take());
//		System.out.println(qa.take());
		LinkedBlockingQueue<String> q=testLinkedBlockingQueue();
		TimeUnit.SECONDS.sleep(1);
		Good:
		while(!q.isEmpty()) {
			System.out.println(q.size());
//			q.forEach(i->System.out.println(i));
			System.out.println(q.take());
			continue Good;
		}
		System.out.println("====");
	}
	
	public static Queue<String> testSyncQueue() {
		SynchronousQueue<String> queue=new SynchronousQueue<String>();
	    ExecutorService es=Executors.newFixedThreadPool(5);
		IntStream.range(0,5).boxed().forEach(i->{
			es.execute(()->{
				try {
					queue.put(Thread.currentThread().getName()+":"+i+"");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    });
		});
		return queue;
	}
	
	public static LinkedBlockingQueue<String> testLinkedBlockingQueue(){
		LinkedBlockingQueue<String> queue=new LinkedBlockingQueue<>(1);
	    ExecutorService es=Executors.newFixedThreadPool(5);
		IntStream.range(0,5).boxed().forEach(i->{
			es.execute(()->{
				try {
					queue.put(Thread.currentThread().getName()+":"+i+"");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    });
		});
		return queue;
	}
}
//               