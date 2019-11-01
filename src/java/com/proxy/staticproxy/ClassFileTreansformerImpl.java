package com.proxy.staticproxy;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class ClassFileTreansformerImpl implements ClassFileTransformer {

	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		System.out.println("当前类加载器:"+classBeingRedefined.getClassLoader());		System.out.println("当前类加载器:"+classBeingRedefined.getClassLoader());
		System.out.println("当前类名:"+className);
		return null;
	}

}
//                           