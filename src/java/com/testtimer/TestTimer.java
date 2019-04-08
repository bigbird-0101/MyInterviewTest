package com.testtimer;

import java.util.Date;
import java.util.Timer;

/**
 * 时间:2019年2月12日
 * @author pefuxc
 * 测试时间控制器
 */
public class TestTimer {

	public static void main(String[] args) {
		Timer aTimer=new Timer(); 
		MyLoveLiLiThread aMyLoveLiLiThread=new MyLoveLiLiThread();
		aTimer.schedule(aMyLoveLiLiThread, new Date(),1000*1);
	}
}
