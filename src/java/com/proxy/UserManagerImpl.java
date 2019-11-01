package com.proxy;

public class UserManagerImpl implements UserManager {

	@Override
	public void add(String userName, String age) {
		System.out.println("UserManagerImpl:add");
	}

	@Override
	public void modify(String userName, String age) {
		System.out.println("UserManagerImpl:modify");
	}

	@Override
	public void delete(String userName, String age) {
		System.out.println("UserManagerImpl:delete");
	}

}
//                                 