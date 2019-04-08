package com.concurrent.importantinterviewsubject;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题目  两个线程 交替输出
 *  一个线程输出  1-62  另外一个线程 输出 A-Z;
 *  交替输出  1，2，A,B,3,4,C，D 这种形式
 *
 *  题目分析：
 *   1.首先判断是否有公共资源 。 该题未涉及共享资源 所以不需要对共享资源进行加锁
 *   2.然后判断是否需要进行线程间通讯，通过线程间通讯变量来实施通讯。  改题目涉及线程间通讯 通过标志位来进行线程间的通讯
 */
public class NoShareSubjectTest2 {

    private static final Object lock=new Object();
    //线程间通讯 标志位  flag 为false 时  数字线程正在输出 反之。
    private static boolean flag=false;
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                int count=0;
                //因为交替输出两个  所以定义一个计数器
                for (int a=1;a<=52;a++){
                    synchronized (lock) {
                            while (flag) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            //设置flag
                            if (flag == false) {
                                System.out.print(a+",");
                                count++;
                                if (count == 2) {
                                    lock.notifyAll();
                                    flag = true;
                                    count=0;
                                }
                            }
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
                public void run(){
                //因为交替输出两个  所以定义一个计数器
                int count=0;
                for (char a='A';a<='Z';a++){
                    synchronized (lock) {
                            while (!flag) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            //设置flag
                            if (flag == true) {
                                System.out.print(a+",");
                                count++;
                                if (count == 1) {
                                    lock.notifyAll();
                                    flag = false;
                                    count=0;
                                }
                            }
                    }
                }
            }
        }.start();
    }
}
