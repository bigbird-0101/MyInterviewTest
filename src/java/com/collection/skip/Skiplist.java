package com.collection.skip;

import java.util.Random;

public class Skiplist {

	private Node head,tail;
	
	private Random random=new Random();
	
	private int height=0;
	
    public Skiplist() {
    	head=new Node(null);
    	tail=new Node(null);
    	head.right=tail;
    }
    
    public boolean search(int t) {
    	Node node=query(t);
    	return node==null?false:node.t==null?false:node.t.intValue()==t;
    }
    //找到该值所在的最近的位置
    private Node query(int t) {
    	Node newNode=new Node(t);
    	Node current=head;
    	for(;;) {
	    	while(current.right!=null&&current.right.t!=null&&current.right.t.intValue()<=newNode.t.intValue()) {
	    			current=current.right;
	    	}
			if(current.down!=null) {
				current=current.down;
			}else {
				break;
			}
    	}
    	return current;
    }
    
    public void add(int num) {
    	Node newNode=new Node(num);
    	//查找到近似的位置
    	Node near=this.query(num);
    	System.out.println(num+":::"+near.t);
		newNode.right=near.right;
		near.right.left=newNode;
		near.right=newNode;
		newNode.left=near;
		int currentLevel=0;
		//随机数当大于0.5开始分层
		while(random.nextDouble()>0.5d) {
			if(currentLevel>=height) {
			    	Node headhead=new Node(null);
			    	Node tailtail=new Node(null);
			    	
			    	headhead.down=head;
			    	headhead.right=tailtail;
			    	head.up=headhead;
			    
			    	tailtail.down=tail;
			    	tailtail.left=headhead;
			    	tail.up=tailtail;
			    	
			    	head=headhead;
			    	tail=tailtail;
				    height++;
			}
			if(currentLevel==0) {
				System.out.println();
			}
			while(near!=null&&near.up==null) {
				near=near.left;
			}
			if(near==null) {
				System.out.println();
			}
			near=near.up;//分层找到所属的near
			Node extractNode=new Node(num);
			Node tailNode=near.right;
			extractNode.right=tailNode;
			tailNode.left=extractNode;
			
			extractNode.left=near;
			near.right=extractNode;
			
			extractNode.down=newNode;
			newNode.up=extractNode;
			
			newNode=extractNode;//忘记了  * 非常重要 
			//可能出现这种情况
			/**
			 * [h]->[1]-[2]--[3]-->[t]
			 * |     |   |   ||     |      3中的第二层和第1层没有关联  第一层直接和第3层相连接了
			 * [h]->[1]-[2]--->[3]-->[t]
			 * |     |   |    |||    |
			 * [h]->[1]->[2]->[3]->[t]
			 */
			currentLevel++;
		}
    }
    
    public void dumpSkipList() {
    	Node temp=head;
    	for (int i = 0; i < height+1; i++) {
    		if(temp==null) {
				return;
			}
			System.out.printf("total [%d] height [%d] ",height+1,i+1 );
			Node node=temp.right;
			while(node.t!=null) {
				System.out.printf("->[%d] ",node.t);
				node=node.right;
			}
			System.out.println("\n");
			temp=temp.down;
		}
    }
    
    
    public int getHeight() {
    	return this.height;
    }
    
    public boolean erase(int num) {
    	//查找到近似的位置
    	Node near=this.query(num);
    	if(near.t!=null&&near.t.intValue()==num) {
    		remove(near);
    		return true;
    	}
		return false;
    }
    
    public void remove(Node node) {
    	while(node!=null) {
	       Node temp=node.left;
		   Node temp2=node.right;
		   temp.right=temp2;
		   temp2.left=temp;
		   node=node.up;
		}
		return;
    }
    
    static final class Node{
    	final Integer t;
    	Node right;
    	Node down;
    	Node up;
    	Node left;
    	Node(Integer t){
    		this.t=t;
    	}
    }
    
    public static void main(String[] args) {
    	Random random=new Random();
    	Skiplist a=new Skiplist();
//    	a.add(1);
//    	a.add(2);
//        a.add(3);
//        System.out.println(a.search(0));
//        a.add(4);
//        System.out.println(a.search(1));
//        System.out.println(a.erase(0));
//        System.out.println(a.erase(1));
//        System.out.println(a.search(1));
    	
     	a.add(1);
    	a.add(2);
        a.add(3);
        System.out.println(a.search(0));
        a.add(4);
        System.out.println(a.search(1));
        System.out.println(a.erase(5));
        System.out.println(a.erase(3));
        System.out.println(a.search(6));
        a.dumpSkipList();
//        [[],[1],[2],[3],[0],[4],[1],[0],[1],[1]]
//        [[],[1],[2],[3],[0],[4],[1],[5],[3],[6]]
	}

}
//