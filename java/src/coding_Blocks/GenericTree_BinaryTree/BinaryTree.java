package coding_Blocks.GenericTree_BinaryTree;

import java.util.*;

public class BinaryTree {

	
	private class Node {
		int data;
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
	private int size=0;
	
	
	BinaryTree(){
		Scanner sc=new Scanner(System.in);
		
		// root to naa left hai naa rigth , isliye boolean false
		// and parent bhi koi nahi hai isliye parent is null
		this.root=takeInput(sc , null , false);
	}
	
	
	BinaryTree(int [] pre , int [] in){
		this.root=pre_in_generate(pre , 0 , pre.length-1 , in , 0 , in.length-1);
	}
	
	
	private Node takeInput(Scanner sc , Node parent , boolean isLeftOrRight){
	// left child ke liye boolean true set kardo and right child ke liye boolean false set kardo
	
		if(parent==null) {
			System.out.println("Enter the data for root node : ");
		} else {
			
			if(isLeftOrRight) {
				System.out.println("Enter the data for left child of "+parent.data);
			} else {
				System.out.println("Enter the data for right chld of "+parent.data);
			}
			
		}
		
		
		int nodeData=sc.nextInt();
		Node node=new Node(nodeData , null , null);
		this.size++;
		
		
		boolean choice=false;
		System.out.println("Do you have left child of "+node.data);
		choice=sc.nextBoolean();
		
		
		if(choice) {
			node.left=takeInput(sc , node , true);
		}
		
		
		choice=false;
		System.out.println("Do you have right child of "+node.data);
		choice=sc.nextBoolean();
		
		
		if(choice) {
			node.right=takeInput(sc , node , false);
		}
		
		
		return node;
		
		
	}


	public void display() {
		this.display(this.root);
	}
	private void display(Node node) {
		
		
		
		String str="";
		
		if(node.left!=null) {
			str=str+node.left.data+" => ";	
		} else {
			str=str+"END => ";
		}
		
		str=str+node.data;
		
		if(node.right!=null) {
			str=str+" <= "+node.right.data;	
		} else {
			str=str+" <= END";
		}
		
		System.out.println(str);
		
		if(node.left!=null) {
			this.display(node.left);
		}
		
		if(node.right!=null) {
			this.display(node.right);
		}

		
		
		
	}
	
	
	public int height() {
		return this.height(this.root);
	}
	private int height(Node node) {
		
		if(node==null) return -1;
				
		int left=1+this.height(node.left);
		
		int right=1+this.height(node.right);
		
		return (left>right)? left : right;
		
	}
	
	
	// preOrder using recursion
	public void preOrder() {
		this.preOrder(this.root);
		System.out.println();
	}
	private void preOrder(Node node) {
		
		if(node==null) return;
		
		System.out.print(node.data+" ");
		
		preOrder(node.left);
		
		preOrder(node.right);
		
	}

	
	// preOrder using iteration
	public void preOrder2() {
		this.preOrder2(this.root);
		System.out.println();
	}
	private void preOrder2(Node node) {
		
		Stack<Node> st=new Stack<>();
		
		st.push(node);
		
		while(!st.isEmpty()) {
			Node temp = st.pop();
			
			System.out.print(temp.data+" ");
			
			if(temp.right!=null)
			st.push(temp.right);
			
			if(temp.left!=null)
			st.push(temp.left);
		}
		
	}
	
	
	public void postOrder() {
		this.postOrder(this.root);
		System.out.println();
	}
	private void postOrder(Node node) {
		
		if(node==null) return;
				
		postOrder(node.left);
		
		postOrder(node.right);
		
		System.out.print(node.data+" ");
		
	}
	
	
	public void inOrder() {
		this.inOrder(this.root);
		System.out.println();
	}
	private void inOrder(Node node) {
		
		if(node==null) return;
				
		inOrder(node.left);
		
		System.out.print(node.data+" ");

		inOrder(node.right);
		
	}


	public void levelOrder() {
		for(int i=0 ; i<=this.height() ; i++)
			this.levelOrder(this.root , 0 , i);
		
		System.out.println();
	}
	private void levelOrder(Node node , int currlevel , int printlevel) {
		
		if(node==null) return;
		
		if(currlevel==printlevel)
			System.out.print(node.data+" ");
		
		if(currlevel!=printlevel)
		{
			levelOrder(node.left , currlevel+1 , printlevel);
			levelOrder(node.right , currlevel+1 , printlevel);
		}
		
	}

	
	// time complexity = O(n)
	public void LevelOrderUsingQueue() {
			
		Queue<Node> q=new LinkedList<>();
		q.add(this.root);

		while(!q.isEmpty())
		{
			Node node=q.remove();
			if(node.left!=null)
			q.add(node.left);
			
			if(node.right!=null)
			q.add(node.right);
		
			System.out.print(node.data+" ");
		}
		
		System.out.println();
		
		
	}

	
	public void bst() {
		System.out.println( this.bst(this.root) );
	}
	private boolean bst(Node node) {
		
		if(node==null) return true;
		
		boolean left=true,right=true;
		
		if(node.left!=null)
		left=allsmaller(node.left , node);
		if(node.right!=null)
		right=allbigger(node.right , node);
		
		
		boolean leftchild=bst(node.left);
		boolean rightchild=bst(node.right);
		
		
		if(left && right && leftchild && rightchild) return true;
		else return false;
	}
	public boolean allsmaller(Node child , Node parent) {
		
		if(child==null) return true;
		if(child.data>parent.data) return false;
		
		boolean res=allsmaller(child.left , parent);
		boolean ans=allsmaller(child.right , parent);
		
		if(res && ans) return true;
		else return false;
	}
	public boolean allbigger(Node child , Node parent) {
		
		if(child==null) return true;
		if(child.data<parent.data) return false;
		
		boolean res=allbigger(child.left , parent);
		boolean ans=allbigger(child.right , parent);
		
		if(res && ans) return true;
		else return false;
	}

	
	public boolean isBST() {
		return this.isBST(this.root , Integer.MIN_VALUE , Integer.MAX_VALUE);
	}
	private boolean isBST(Node node , int min , int max) {
	
		if(node==null) return true;
		
 		if(node.data<min || node.data>max) return false;
				
		boolean left = isBST(node.left , min , node.data);
		boolean right = isBST(node.right , node.data , max);
		
		
		return (left && right)? true : false ;
		
	}
	
	
	public int sumleaf() {
		return this.sumleaf(this.root);
	}
	private int sumleaf(Node node) {
		
		if(node==null) return 0;
		
		if(node.left==null && node.right==null)
			return node.data;
		
		int left=sumleaf(node.left);
		int right=sumleaf(node.right);
		
		return left+right;
	}
	
	
	// O(n^2) approach for finding diameter
	public int diameter() {
		return this.diameter(this.root);
	}
	private int diameter(Node node) {
		
		// base case
		if(node==null) return 0;
		
		// when diameter passes through the root
		int case1 = 2 + this.height(node.left) + this.height(node.right);
	
		// when diameter is in left side of tree
		int case2 = diameter(node.left);
		 
		// when diameter is in right side of tree
		int case3 = diameter(node.right);
		
		// return ans
		return Math.max( case1 , Math.max(case2 , case3) );
	
	}

	
	// O(n) approach for finding diameter
	private class diaPair {
		int diameter;
		int height;
		
		diaPair(){
			
		}
		
		diaPair(int height , int diameter){
			this.diameter=diameter;
			this.height=height;
		}
		
	}
	public int diameterbetter() {
		return this.diameterbetter(this.root).diameter;
	}
	private diaPair diameterbetter(Node node) {
		
		if(node==null) {
			diaPair bp=new diaPair(-1,0);
			return bp;
		}
		
		diaPair lp=diameterbetter(node.left);
		diaPair rp=diameterbetter(node.right);
		
		
		diaPair mp=new diaPair();
		mp.height=Math.max(lp.height , rp.height)+1;
		mp.diameter=Math.max(lp.height+rp.height+2 , Math.max(lp.diameter , rp.diameter));
		
		return mp;
	}
	
	
	// O(n^2) approach for checking
	public boolean isBalanced() {
		return this.isBalanced(this.root);
	}
	private boolean isBalanced(Node node) {
		
		if(node==null) return true;
			
		boolean ls=isBalanced(node.left);
		boolean rs=isBalanced(node.right);
	
		int bf=height(node.left) - height(node.right);
		
		if( (bf==-1 || bf==0 || bf==1) && (ls && rs))
			return true;
		else
			return false;
		
	}
	
	
	// O(n) approach for checking
	private class balpair {
		int height;
		boolean balanced;
		
		balpair(){
			
		}
		
		balpair(int height , boolean balanced){
			this.height=height;
			this.balanced=balanced;
		}
	}
	public boolean isBalanced2() {
		return isBalanced2(this.root).balanced ;
	}
	private balpair isBalanced2(Node node) {
		
		if(node==null) {
			balpair basecase = new balpair(-1 , true);
			return basecase;
		}
		
		balpair ls = isBalanced2(node.left);
		balpair rs = isBalanced2(node.right);
		
		int bf=ls.height-rs.height;
		
		balpair curr = new balpair();
		curr.height = Math.max(ls.height , rs.height)+1;
		
		if( (bf==1 || bf==0 || bf==-1) && (ls.balanced && rs.balanced) )
			curr.balanced=true;
		else
			curr.balanced=false;
		
		
		return curr;
			
	}

	
	public int sum() {
		return this.sum(this.root);
	}
	private int sum(Node node) {
		
		if(node==null) return 0;
		
		int ls = sum(node.left);
		int rs = sum(node.right);
		
		return node.data + ls + rs ;
	}
	
	
	// global variable is used
	public int maxsum=Integer.MIN_VALUE;
	public int maxsubsum() {
		this.maxsubsum(this.root);
		return maxsum;
	}
	private int maxsubsum(Node node) {
		
		if(node==null) return 0;
		
		int ls = maxsubsum(node.left);
		int rs = maxsubsum(node.right);
		
		int curr = ls+rs+node.data;
		
		if(maxsum<curr)
			maxsum=curr;
		
		return curr;
		
	}
	
	
	class maxsumpair{
		int totalsum=0;
		int maxsum=0;
	}
	public int maxsubsum2() {
		return this.maxsubsum2(this.root).maxsum;
	}
	private maxsumpair maxsubsum2(Node node) {
		
		
		if(node == null) {
			maxsumpair base = new maxsumpair();
			return base;
		}
		
		maxsumpair ls = maxsubsum2(node.left);
		maxsumpair rs = maxsubsum2(node.right);
		
		maxsumpair curr = new maxsumpair();
		curr.totalsum = ls.totalsum + rs.totalsum + node.data;
		curr.maxsum = Math.max(curr.totalsum , Math.max(ls.maxsum , rs.maxsum));
		
		return curr;
		
		
		
	}

	
	private Node pre_in_generate(int [] pre , int preS , int preE , int [] in , int inS , int inE) {
		
		if(preS>preE || inS>inE)
			return null;
	
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
		
		return curr;
		
	}
	
	
	
}

