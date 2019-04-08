package com.concurrent;
/**
 * ʱ��:2019��1��21��
 * @author pefuxc
 *
 */
public class TestConCurrent {
	private boolean flag=true;
	private static int a=0;
	public static void main(String[] args) throws InterruptedException {
		testThread();
//		MyThread aMyThread=new MyThread();
//		Thread aThread=new Thread(aMyThread);
//		aThread.setName("�����߳�");
//		aThread.start();
		
//		MyThread2 aMyThread=new MyThread2();
//		Thread aThread=new Thread(aMyThread);
//		aThread.setName("�����߳�");
//		aThread.start();
//		aThread.sleep(2000);
//		aThread.interrupt();
//		while(true){
//			MyThread3 aMyThread=new MyThread3();
//			Thread aThread=new Thread(aMyThread);
//			aThread.setName("�����߳�");
//			aThread.start();
//			Thread.sleep(1000);
//			aThread.interrupt();
//			
//			
//			MyThread3 aMyThread2=new MyThread3();
//			Thread aThread2=new Thread(aMyThread2);
//			aThread2.setName("�����߳�");
//			aThread2.start();
//			Thread.sleep(1000);
//			aThread2.interrupt();
//			
//			System.out.println();
//			a++;
//			if(a==100){
//				break;
//			}
//		}
//		System.out.println("����");
	}
	
	public static void testThread(){
		Thread[] aArrayThread=new Thread[3];
		for (int i = 0; i < aArrayThread.length; i++) {
			aArrayThread[i]=new Thread(){
				public void run(){
					for (int j = 0; j < 5; j++) {
						System.out.print(j);
					}
					System.out.print("");
				}
			};
		}
		for (Thread thread : aArrayThread) {
			thread.start();
		}
	}
}

/**
 * �̲߳���
 * ʱ��:2019��1��22��
 * @author pefuxc
 *
 */
class MyThread extends Thread {
	private boolean flag=false;
	private int a=0;
	public void setFlag(){
		flag=true;
	}
	public int getA(){
		return a;
	}
	@Override
	public void run() {
		while(true){
			if(flag){
				break;
			}
			System.out.println("LILI LILI:"+a);
			a++;
			if(a==100){
				setFlag();
			}
		}
		
	}
}

/**
 * 
 * ʱ��:2019��1��22��
 * @author pefuxc
 *
 */

class MyThread2 implements Runnable {

	@Override
	public void run() {
		while(true){
			System.out.println("LILI---------LI");
			System.out.println(Thread.currentThread().isInterrupted());
			if(Thread.currentThread().isInterrupted()){
				break;
			}
	        
		}
	}
	
}


class MyThread3 implements Runnable {

	@Override
	public void run() {
		while(true){
			System.out.println("LILI---------LI");
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().isInterrupted());
			if(!Thread.currentThread().isInterrupted()){
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("�߳��ж���");
				System.out.println(Thread.currentThread().getName());
				Thread.currentThread().interrupted();
			}
			System.out.println("end........");
		}
	}
	
}



