package com.testtimer;

import java.util.TimerTask;

/**
 * 时间:2019年2月12日
 * @author pefuxc
 *
 */
public class MyLoveLiLiThread extends TimerTask {

	private int a=0;
	@Override
	public void run() {
		a++;
		System.out.println("爱莉莉"+a+"次");
	}

}
