package com.proxy.staticproxy;

import com.proxy.UserManager;

public class UserManagerProxy implements UserManager {

	private UserManager manager;
	
	UserManagerProxy(UserManager manager){
		this.manager=manager;
	}
	
	@Override
	public void add(String userName, String age) {
		manager.add(userName, age);
	}

	@Override
	public void modify(String userName, String age) {
		manager.modify(userName, age);
	}

	@Override
	public void delete(String userName, String age) {
		manager.delete(userName, age);
	}

}
//