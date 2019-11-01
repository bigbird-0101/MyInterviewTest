package com.concurrent.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ddd {
	public static void main(String[] args) {
		final DBPool aDBPool=new DBPool();
		try {
			Connection a=aDBPool.getConnection();
			PreparedStatement aPreparedStatement=a.prepareStatement("select * from aaa");
			ResultSet ab=aPreparedStatement.executeQuery();
			while(ab.next()) {
				String ddd=ab.getString("b");
				String ddd1=ab.getString("c");
				String ddd2=ab.getString("d");
				String ddd3=ab.getString("e");
				String ddd4=ab.getString("f");
				String ddd5=ab.getString("g");
				String ddd6=ab.getString("h");
				String ddd7=ab.getString("j");
				System.out.println(ddd+"\t"+"        "+ddd1+"\t"+"       "+ddd2+"\t"+"        "+ddd3+"\t"+"         "+ddd4+"\t"+"          "+ddd5+"\t"+"         "+ddd6+"\t"+"        "+ddd7+"\t");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//