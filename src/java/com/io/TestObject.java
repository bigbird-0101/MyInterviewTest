package com.io;

import java.io.File;
import java.io.Serializable;

/**
 * @author pefuxc
 *
 */
public class TestObject {

	public static void main(String[] args) {
		File aFile=new File("D:/");
	}
}

class Person implements Serializable {
	int i=0;
	String name="������";
}
