package com.concurrent.importantinterviewsubject;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题目  两个线程 交替输出
 * 一个线程输出  1-62  另外一个线程 输出 A-Z;
 * 交替输出  1，2，A,B,3,4,C，D 这种形式
 * <p>
 * 题目分析：
 * 1.首先判断是否有公共资源 。 该题未涉及共享资源 所以不需要对共享资源进行加锁
 * 2.然后判断是否需要进行线程间通讯，通过线程间通讯变量来实施通讯。  改题目涉及线程间通讯 通过标志位来进行线程间的通讯
 */
public class PrintResourceSubjectTest {
    private static final Lock lock = new ReentrantLock();
    private static final Condition lockCondition = lock.newCondition();
    private static final Condition lockCondition2 = lock.newCondition();

    //线程间通讯 标志位  flag 为false 时  数字线程正在输出 反之。
    private static volatile boolean flag = false;

    public void printLetter(){
        try{
            int count = 0;

            for (char a = 'A'; a <= 'Z'; a++) {
                System.out.println("letter lock");
                lock.lock();
                while (!flag) {
                    try {
                        lockCondition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
                //设置flag
                if (flag == true) {
                    System.out.print(a + ",");
                    count++;
                    if (count == 1) {
                        lockCondition.signalAll();
                        flag = false;
                        count = 0;
                        System.out.println("letter unlock");
                        lock.unlock();
                    }
                }

            }
        }finally {

        }
    }

    public void printLNumber(){
        try{
            int count = 0;

            for (int a = 1; a <= 62; a++) {
                System.out.println("number lock");
                lock.lock();
                while (flag) {
                    try {
                        lockCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
                //设置flag
                if (flag == false) {
                    System.out.print(a + ",");
                    count++;
                    if (count == 2) {
                        lockCondition2.signalAll();
                        flag = true;
                        count = 0;
                        System.out.println("number unlock");
                        lock.unlock();
                    }
                }

            }
        }finally {

        }
    }

    public static void main(String[] args) {
        final PrintResourceSubjectTest aPrintResourceSubjectTest=new PrintResourceSubjectTest();
        new Thread(){
            @Override
            public void run() {
                aPrintResourceSubjectTest.printLNumber();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                aPrintResourceSubjectTest.printLetter();
            }
        }.start();
    }
}
