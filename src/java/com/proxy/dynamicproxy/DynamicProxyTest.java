package com.proxy.dynamicproxy;

import com.proxy.UserManager;
import com.proxy.UserManagerImpl;

public class DynamicProxyTest {

	public static void main(String[] args) {
		UserManager um=(UserManager)(new DynamicProxy().newProxyInstance(new UserManagerImpl()));
		um.add("你好", "犀利");
	}
}
//