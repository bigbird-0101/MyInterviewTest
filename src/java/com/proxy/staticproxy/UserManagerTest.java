package com.proxy.staticproxy;

import com.proxy.UserManager;
import com.proxy.UserManagerImpl;

public class UserManagerTest {

	public static void main(String[] args) {
		UserManager manager=new UserManagerProxy(new UserManagerImpl());
		manager.add("a", "b");
	}
}
//