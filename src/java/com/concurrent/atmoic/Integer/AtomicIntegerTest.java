package com.concurrent.atmoic.Integer;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	public static void main(String[] args) {
		AtomicInteger a=new AtomicInteger();
		System.out.println(a.incrementAndGet());
		System.out.println(a.compareAndSet(2, 3));
		System.out.println(a.get());
	}
}
//      