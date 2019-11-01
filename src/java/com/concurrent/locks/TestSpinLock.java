package com.concurrent.locks;

import java.util.stream.IntStream;

public class TestSpinLock {
	private final SpinLock lock=new SpinLock();
	private int a=0;
    public void add() {
    	lock.lock();
    	a++;
    	System.out.println(a);
    	lock.unlock();
    }
	
    public static void main(String[] args) {
    	TestSpinLock a=new TestSpinLock();
		IntStream.range(0, 5).boxed().forEach(i->{
			new Thread(()->{
			    IntStream.range(0, 100).boxed().forEach(d->{
			    	a.add();
			    });
			}
			).start();
		});
	}
}
//