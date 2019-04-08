package com.mianshi.suanfa;



/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء� ʱ��:2019��2��18��
 * 
 * 
 * ����������� ȷ�� ���ڵ� ��Ȼ�������������е�,���ڵ�ȷ�� ���һ���  ���ڵ���ߵ�Ϊ������  ���ڵ��ұߵ�Ϊ������
 * ���������ϵݹ�  
 * ���������ϵݹ�
 * @author pefuxc
 *
 */
public class Test3 {
	//[1,2,3,4],[1,2,3,4]
	public static void main(String[] args) {
		TreeNode root=new Test3().reConstructBinaryTree(new int[]{1,2,3,4}, new int[]{1,2,3,4});
		System.out.println(root.toString());
	}
	/**
	 * 
	 * @param pre  �������
	 * @param in   �������
	 * @return
	 */
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if(pre==null||in==null){
			return null;
		}
		//�������һ��Ϊ�������ĸ��ڵ�
		TreeNode aTreeNode=new TreeNode(pre[0]);
		//�����������������ҵ����ڵ�  ���ڵ���ߵ�Ϊ�����������ڵ��ұߵ�Ϊ������
		for (int i = 0; i < in.length; i++) {
			if(in[i]==pre[0]){
				//�õ����������������  �� �������
				int[] newLeftPre=cat(pre,1,i+1,i);
				int[] newLeftIn=cat(in,0,i,i);
				int[] newRigthPre=cat(pre,i+1,pre.length,pre.length-i-1);
				int[] newRigthIn=cat(in,i+1,in.length,in.length-i-1);
				//���ǰ����������������
				if(newLeftPre!=null&&(newLeftPre.length==2&&newLeftIn.length==2)&&(newLeftPre[0]==newLeftIn[0]&&newLeftPre[1]==newLeftIn[1])){
					//�������һ��Ϊ�������ĸ��ڵ�
					TreeNode aTreeNodeLeft=new TreeNode(newLeftIn[0]);
					TreeNode aTreeNodeRight=new TreeNode(newLeftIn[1]);
					aTreeNode.left=aTreeNodeLeft;
					aTreeNode.right=aTreeNodeRight;
					return aTreeNode;
				}
				//���ǰ����������������
				if(newRigthPre!=null&&(newRigthPre.length==2&&newRigthIn.length==2)&&(newRigthPre[0]==newRigthIn[0]&&newRigthPre[1]==newRigthIn[1])){
					//�������һ��Ϊ�������ĸ��ڵ�
					TreeNode aTreeNodeLeft=new TreeNode(newRigthPre[0]);
					TreeNode aTreeNodeRight=new TreeNode(newRigthPre[1]);
					aTreeNode.left=aTreeNodeLeft;
					aTreeNode.right=aTreeNodeRight;
					return aTreeNode;
				}
				aTreeNode.left=reConstructBinaryTree(newLeftPre,newLeftIn);
			    aTreeNode.right=reConstructBinaryTree(newRigthPre,newRigthIn);
			    break;
			}
		}
		return aTreeNode;
	}
	
	public int[] cat(int[] array,int startIndex,int endIndex,int length){
	   if(length==0){
		   return null;
	   }
	   int[] result=new int[length];
	   int b=0;
	   for(int a=startIndex;a<endIndex;a++){
		   result[b]=array[a];
		   b++;
	   }
	   return result;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
	public String toString(){
		return val+"";
	}
}

class Test{
	public static void main(String[] args) {
		new Test().reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6});
	}
	public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        System.out.println(root.toString());
        return root;
    }
    //ǰ�����{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre, int startPre, int endPre, int [] in, int startIn, int endIn) {
         
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);
         
        for(int i=startIn;i<=endIn;i++){
        	if(i==endIn){
        		System.out.println();
        	}
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }
        }       
        return root;
    }
}

