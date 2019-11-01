package com.proxy.staticproxy;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * 静态代理
 * @author corget
 *
 */
public class StaticProxy {

	public static void premain(String args,Instrumentation instrumentation) {
		ClassFileTransformer i=new ClassFileTreansformerImpl();
		instrumentation.addTransformer(i);
	}
}
//