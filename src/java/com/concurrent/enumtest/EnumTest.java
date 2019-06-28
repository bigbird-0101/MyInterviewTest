package com.concurrent.enumtest;

public class EnumTest {

	private enum State{
		NEW(0),RUNNABLE(1),RUNNING(2),BLOCKED(3),DEAD(4);

	    public int statusCode;

	    State(int statusCode){
	        this.statusCode = statusCode;
	    }
	}
	public static void main(String[] args) {
		int statusCode = State.valueOf("NEW").statusCode;
		System.out.println(statusCode);
	}
}
//                                                                                                                                                   