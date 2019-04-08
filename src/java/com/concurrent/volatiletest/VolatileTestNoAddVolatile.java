package com.concurrent.volatiletest;
/**
 * 时间:2019年3月11日
 * @author pefuxc
 *
 */
public class VolatileTestNoAddVolatile {

	/**
	 * 解决高速缓存一致性问题
	 * 
	 * 1.方案一： 给数据总线加锁
	 *     总线：数据总线、地址总线、控制总线
	 *     lock
	 * 2.方案二：cpu高速缓存一致性协议
	 *    Inter  MESI    
	 *    volatile 关键字的作用：
	 *    当一个变量被volatile修饰时，当前这个线程会告诉其他线程这个变量在内存当中的缓存不管用了，当其他线程需要这个变量时，
	 *    去到主内存当中去取。
	 *     
	 */
	private static  int INIT_VALUE=0;
	private static final int LAST_VALUE=50;
	
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				while(INIT_VALUE<=LAST_VALUE){
					System.out.println("T1"+"不相等"+"INIT_VALUE::"+INIT_VALUE++);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				    
				}
			}
		}.start();
		
		new Thread(){
			public void run(){
				while(INIT_VALUE<=LAST_VALUE){
					System.out.println("T2"+"不相等"+"INIT_VALUE::"+INIT_VALUE++);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
