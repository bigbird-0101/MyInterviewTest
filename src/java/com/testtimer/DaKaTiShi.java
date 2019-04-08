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
 * ʱ��:2019��3��6��
 * @author pefuxc
 *
 */
public class DaKaTiShi extends TimerTask {

	private Frame aFrame=new Frame();
	private static long daySpan = 24 * 60 * 60 * 1000;
	private Button login=new Button("ȷ��");
	private Label login_clew=new Label();
	private static String aMorningDate="2019-03-06 09:00:00";
	private String aNightDate="2019-03-06 09:00:00";
	private static Date b=null;
	private static int count=0;
	private Calendar c = Calendar.getInstance();
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
		login.setBounds(90, 200, 60, 30);
		login.setVisible(true);
		aFrame.add(login);
		
		login_clew.setBounds(90,160,200,30);
	    login_clew.setText("��Ŷ,�ϵܣ�");
	    aFrame.add(login_clew);
	    DaKaTiShiActionListener aDaKaTiShiActionListener=new DaKaTiShiActionListener();
		login.addActionListener(aDaKaTiShiActionListener);
	}
	@Override
	public void run() {
		init();
		//ÿִ����һ��
        c.setTime(b);
        c.add(Calendar.DAY_OF_MONTH, 1);// ��
        b=c.getTime();
        System.out.println(b.getTime());
	}
	public static void main(String[] args) {
		try {
			if(count==0){
			   b=a.parse(aMorningDate);
			   count=1;
			}
			System.out.println(count);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Timer aTimer=new Timer();
//		Timer aTimer2=new Timer(); 
		DaKaTiShi aDaKaTiShi=new DaKaTiShi();
//		DaKaTiShi aDaKaTiShi2=new DaKaTiShi();
		aTimer.schedule(aDaKaTiShi,b,daySpan);
//		aTimer2.schedule(aDaKaTiShi2, new Date(),2000*1);
	}
}
