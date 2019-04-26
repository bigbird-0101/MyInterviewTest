package com.testtimer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author pefuxc
 *
 */
public class DaKaTiShi extends TimerTask {

	private Frame aFrame=new Frame();
	private static long daySpan = 24 * 60 * 60 * 1000;
	private Button login=new Button("ok");
	private Label login_clew=new Label();
	private static String aMorningDate="2019-04-18 08:20:00";
	private static String aNightDate="2019-04-18 19:00:00";
	private static String aNightDate2="2019-04-18 19:15:00";
	
	private static SimpleDateFormat a=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private class DaKaTiShiActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object aName=e.getSource();
			if(aName==login){
				aFrame.setVisible(false);
			}
		}
	}
	private void init(){
		aFrame.setLocationRelativeTo(null);
		aFrame.setLayout(null);
		aFrame.setSize(400,300);
		aFrame.setVisible(true);
		aFrame.setResizable(false);
		login.setBounds(140, 200, 60, 30);
		login.setVisible(true);
		aFrame.add(login);
		
		login_clew.setBounds(90,100,200,30);
		login_clew.setBackground(Color.RED);
		login_clew.setSize(230, 30);
	    login_clew.setText("Don't forget to punch in even after work.");
	    aFrame.add(login_clew);
	    DaKaTiShiActionListener aDaKaTiShiActionListener=new DaKaTiShiActionListener();
		login.addActionListener(aDaKaTiShiActionListener);
	}
	@Override
	public void run() {
		init();
	}
	public static void main(String[] args) {
		Date b = null;
		Date d = null;
		Date e = null;
		try {
			b = a.parse(aMorningDate);
			d = a.parse(aNightDate);
			e = a.parse(aNightDate2);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Timer aTimer=new Timer();
		DaKaTiShi aDaKaTiShi=new DaKaTiShi();
		DaKaTiShi aDaKaTiShi2=new DaKaTiShi();
		DaKaTiShi aDaKaTiShi3=new DaKaTiShi();
		aTimer.schedule(aDaKaTiShi,b,daySpan);
		aTimer.schedule(aDaKaTiShi2, d,daySpan);
		aTimer.schedule(aDaKaTiShi3,e,daySpan);
	}
}
