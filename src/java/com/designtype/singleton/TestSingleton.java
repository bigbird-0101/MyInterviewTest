package com.designtype.singleton;
/**
 * ʱ��:2019��2��14��
 * @author pefuxc
 *
 */
public class TestSingleton {

	private volatile TestSingleton aTestSingleton=null;
	
	private static int a=0;
	
	static class singleton{
		private static final TestSingleton aLast=new TestSingleton();
	}
	
	public TestSingleton getTestSingleton(){
		if(aTestSingleton == null){
			synchronized (TestSingleton.class) {
				return singleton.aLast;
			}
		}
		return aTestSingleton;
	}
	
	
	public static void main(String[] args) {
		
//		for (int i = 0; i <100; i++) {
//			SingletonThread aSingletonThread=new SingletonThread();
//			Thread aThread=new Thread(aSingletonThread);
//			aThread.setName("�߳�"+i);
//			aThread.start();
//		}
		SingletonThread aSingletonThread=new SingletonThread();
		Thread aThread=new Thread(aSingletonThread);
		aThread.setName("�߳�"+1);
		aThread.start();
		SingletonThread aSingletonThread1=new SingletonThread();
		Thread aThread2=new Thread(aSingletonThread1);
		aThread2.setName("�߳�"+2);
		aThread2.start();
		
		SingletonThread aSingletonThread2=new SingletonThread();
		Thread aThread3=new Thread(aSingletonThread2);
		aThread3.setName("�߳�"+3);
		aThread3.start();
	}
}

class SingletonThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"   :"+SingletonHungry.getSingletonHungry().hashCode());
	}
	
}

/**
 * ��̬�ڲ���ʵ��
 * ʱ��:2019��2��14��
 * @author pefuxc
 *
 */
class Singleton {

	static class singleton{
		//����final ȷ��ֻ��ʵ����һ��   ���ʼ��  singleton
		private static final Singleton aLast=new Singleton();
		
		//ע����  ��ֻ������ʱ�����Ǳ���ʱ���������ʼ�� singleton  Ҳ�Ͳ���ִ�о�̬��������еĳ���
		private static final String a="1";
	}
	
	public static Singleton getTestSingleton(){
		return singleton.aLast;
	}
}

/**
 * ����ʽ  ����ģʽ �̰߳�ȫ����Ч�ʼ���
 * ʱ��:2019��2��14��
 * @author pefuxc
 *
 */
class SingletonLanKong{
	/**
	 * Ϊ��Ҫ�� volatile ��  ��Ϊ��jvm��������ָ��ִ��˳��  
	 * 
	 * ��������� jvm �ɵ�����
	 * 1.Ϊ  ��������ڴ��ַ
	 * 2.��ʼ�� ����ʵ��
	 * 3. ����ʵ�� ָ�����ĵ�ַ
	 */
	private static volatile SingletonLanKong aSingletonLanKong=null;
	private  SingletonLanKong(){
		
	}
	public synchronized static SingletonLanKong getSingletonLanKong(){
		if(aSingletonLanKong==null){
			aSingletonLanKong=new SingletonLanKong();
		}
		return aSingletonLanKong;
	}
}

/**
 * ����ʽ  ����ģʽ  �̲߳���ȫ �����߳��²���
 * ʱ��:2019��2��14��
 * @author pefuxc
 *
 */
class SingletonHungry{
	//����Ҳ��  �������û���ӳ���  ʹ�þ�̬�ڲ�������ӳ��ӳٴ������󣬽�ʡ�ռ�
	private static SingletonHungry aSingletonHungry=new SingletonHungry();
	public static SingletonHungry getSingletonHungry(){
		if(aSingletonHungry==null){
			return aSingletonHungry;
		}
		return aSingletonHungry;
	}
}

