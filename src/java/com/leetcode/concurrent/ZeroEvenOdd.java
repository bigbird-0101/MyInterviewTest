package com.leetcode.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
	private int n;
	// 定义一个原子变量作为计算序列的长度
	private AtomicInteger length = new AtomicInteger(0);
	// 通过长度来判断是该输出基数还是偶数
	private AtomicInteger isEvenAndOdd = new AtomicInteger(0);

	private boolean zeroFlag = false;

	private Object lock = new Object();

	public ZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int a = 0; a < (n / 2) + 1; a++) {
			synchronized (lock) {
				if (length.compareAndSet(2 * n, 0))
					return;
				while (zeroFlag) {
					lock.wait();
				}
				printNumber.accept(0);
				length.incrementAndGet();// 长度加1
				zeroFlag = true;
				lock.notifyAll();
			}
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int a = 0; a < (n / 2) + 1; a++) {
			synchronized (lock) {
				if (length.compareAndSet(2 * n, 0))
					return;
				while (isEvenAndOdd.get() % 2 != 0 && !zeroFlag) {
					lock.wait();
				}
				printNumber.accept(isEvenAndOdd.incrementAndGet());
				length.incrementAndGet();// 长度加1
				zeroFlag = false;
				lock.notifyAll();
			}
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int a = 0; a < (n / 2) + 1; a++) {
			synchronized (lock) {
				if (length.compareAndSet(2 * n, 0))
					return;
				while (isEvenAndOdd.get() % 2 == 0 && !zeroFlag) {
					lock.wait();
				}
				printNumber.accept(isEvenAndOdd.incrementAndGet());
				length.incrementAndGet();// 长度加1
				zeroFlag = false;
				lock.notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		try {
			char integer = (char) System.in.read();
			System.out.println("传入n: " + integer);
			int input = (char) integer - (char) '0';
			ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(input);
			IntConsumer intConsumer = value -> System.out.print(value);
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						zeroEvenOdd.zero(intConsumer);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						zeroEvenOdd.odd(intConsumer);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						zeroEvenOdd.even(intConsumer);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//                                                                                                                                                                                                                                                                                                                                                          