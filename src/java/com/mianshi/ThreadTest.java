package com.mianshi;

import java.util.ArrayList;

/**
 * ʱ��:2019��2��13��
 * @author pefuxc
 * 
 *
 */
public class ThreadTest {

    public static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        Thread t1 = new ThreadTest().new MyThread();
        Thread t2 = new Thread(new ThreadTest().new MyRunnable());
        t1.setPriority(3);
        t2.setPriority(8);
        t2.start();
        t1.start();
       
        t2.join();
        for (int i = 0; i < 100000; i++) {
            i++;
        }
        list.add("main");
        
        t1.join();

        for (String s : list) {
            System.out.println(s);
        }
    }

    class MyThread extends Thread {
        @Override
        public void run(){
            for (int i = 0; i < 100000; i++) {
                i++;
            }
            list.add("Thread 1");
        }
    }

     class MyRunnable implements Runnable {
        @Override
        public void run(){
            for (int i = 0; i < 100000; i++) {
                Thread.yield();
                i++;
            }
            list.add("Thread 2");
        }
    }
}