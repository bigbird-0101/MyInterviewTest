package com.jdk8newfeatures.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest {

	public static void main(String[] args) {
//		iterate();
		skip();
	}
	
	public static void iterate() {
		Stream.iterate(1, n->n+1).limit(5).forEach(s->System.out.println(s));
	}
	
	/**
	 * 跳跃  指代跳过某个角标,参数为指代跳过角标
	 * 例如 当参数为2时,那么将跳过索引为2的，从3直接开始,如果参数为0,将从头开始
	 */
	public static void skip() {
	      List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
          list.stream().skip(1).forEach(System.out::println);
	}
}
//