package com.concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自旋锁
 * @author corget
 *
 */
public class SpinLock implements Lock{

	private AtomicReference<Thread> reference=new AtomicReference<Thread>();
	
	@Override
	public void lock() {
		Thread current=Thread.currentThread();
		while(!reference.compareAndSet(null, current)) {
			
		}
		System.out.println();
		System.out.println(current.getName()+"  get lock");
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		
	}

	@Override
	public boolean tryLock() {
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public void unlock() {
		Thread current=Thread.currentThread();
		reference.compareAndSet(current, null);
		System.out.println(current.getName()+" unlock");
		System.out.println();

	}

	@Override
	public Condition newCondition() {
		return null;
	}
	
}
//   