package com.mianshi.suanfa;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * 
 * 用一个栈 来实现入队列，出队列用另外一个栈（入队列的栈的数据，当他出队列是，把他放入这个栈）
 * 时间:2019年2月18日
 * @author pefuxc
 *
 */
public class Test4 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public static void main(String[] args) {

    	Test4 a=new Test4();
    	a.push(1);
    	a.push(2);
    	a.push(3);
    	a.push(4);
    	System.out.println(a.pop());
    	System.out.println(a.pop());
    	System.out.println(a.pop());
    	System.out.println(a.pop());
	}
    public void push(int node) {
    	stack1.push(node);
    }
    
    public int pop() {
    	if(!stack1.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
    	}
		return stack2.pop();
    }
}
