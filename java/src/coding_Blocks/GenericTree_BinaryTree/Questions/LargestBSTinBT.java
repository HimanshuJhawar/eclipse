package coding_Blocks.GenericTree_BinaryTree.Questions;
import java.util.*;

public class LargestBSTinBT {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		int pre[]=new int[n];
		for(int i=0 ; i<n ; i++)
			pre[i]=sc.nextInt();
		
		int in[]=new int[n];
		for(int i=0 ; i<n ; i++)
			in[i]=sc.nextInt();
		
		BinaryTree4 bt = new BinaryTree4(pre , in);
		System.out.println(bt.largestBST());
	}

}

class BinaryTree4 {

	private class Node {
		int data;
		int size=1;
		Node left;
		Node right;
		
		Node(){
			
		}
		
		Node(int data , Node left , Node right){
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}
	
	private Node root=null;
		
	BinaryTree4(int [] pre , int [] in){
		this.root=pre_in_generate(pre , 0 , pre.length-1 , in , 0 , in.length-1);
	}
	
	private Node pre_in_generate(int [] pre , int preS , int preE , int [] in , int inS , int inE) {
		
		if(preS>preE || inS>inE)
			return null;
		if(preS==preE || inS==inE) {
			Node temp=new Node();
			temp.data=pre[preS];
			return temp;
		}
	
		int i=inS;
		while(i<inE) {
			if(pre[preS]==in[i])
				break;
			i++;
		}
		
		Node curr = new Node();
		
		curr.data = in[i];
		
		curr.left = pre_in_generate(pre , preS+1 , preS+(i-inS) , in , inS , i-1);
		
		curr.right = pre_in_generate(pre , preS+(i-inS)+1 , preE , in , i+1 , inE);
		
		if(curr.left!=null && curr.right!=null)
			curr.size=curr.left.size + curr.right.size + 1;
		else if(curr.left==null && curr.right!=null)
			curr.size=curr.right.size+1;
		else if(curr.left!=null && curr.right==null)
			curr.size=curr.left.size+1;
		else
			curr.size=1;
		
		
		return curr;
	}

	public void display() {
		display(this.root);
	}
	private void display(Node node) {
		
		if(node==null) return;
		
		String s="";
		
		if(node.left!=null)		s=s + node.left.data + " => ";
		else	s=s+" ... => ";
		
		s = s+node.data;
		
		if(node.right!=null)    s=s+" <= "+node.right.data;
		else	s=s+" <= ... ";
		
		System.out.println(s);
		
		if(node.left!=null)
			display(node.left);
		
		if(node.right!=null)
			display(node.right);
		
	}
	
	private int maxsize=0;
	public int largestBST() { 
		this.largestBST(this.root);
		return maxsize;
	}
	private void largestBST(Node node) {
		if(node==null) return;
		isBST(node , Integer.MIN_VALUE , Integer.MAX_VALUE);
		largestBST(node.left);
		largestBST(node.right);		
	}
	private boolean isBST(Node node , int min , int max) {
	
		if(node==null) return true;
		
		boolean self=true;
 		if(node.data<min || node.data>max) 
 			self = false;
		boolean left = isBST(node.left , min , node.data);
		boolean right = isBST(node.right , node.data , max);
		
		if(left && right) {
			if(maxsize<node.size)
				maxsize=node.size;
		}
		
		return (left && right && self)? true : false ;
		
	}
	
	
	
}
