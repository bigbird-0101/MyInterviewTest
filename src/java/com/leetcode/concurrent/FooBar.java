package com.leetcode.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class FooBar {
    private int n;

    private boolean flag=false;
    
    private Object d=new Object();
    
    private AtomicInteger ab=new AtomicInteger();
    
    
    
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(){
        
        for (int i = 0; i < n; i++) {
        	synchronized (d) {
	        	while(flag) {
	        		try {
						d.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	        	}
        	
        	  // printFoo.run() outputs "foo". Do not change or remove this line.
        	  System.out.print("foo");
        	  //通知第二个线程工作
        	  flag=true;
        	  d.notifyAll();
        	}
        }
    }

    public void bar() {
        
        for (int i = 0; i < n; i++) {
        	synchronized (d) {
	        	while(!flag) {
	        		try {
						d.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	        	}
	             // printBar.run() outputs "bar". Do not change or remove this line.
	        	 System.out.print("bar");
	        	 flag=false;
	        	 d.notifyAll();
        	}
        }
    }
    
    public static void main(String[] args){
    	FooBar a=new FooBar(3);
    	new Thread(()->{a.foo();}).start();
    	new Thread(()->{a.bar();}).start();
	}
}
//                                                                                                                       