package coding_Blocks.GenericTree_BinaryTree.Questions;

import java.util.*;

public class TopView {

	public static void main(String[] args) {
		
		 Scanner sc=new Scanner(System.in);
		 ArrayList<Integer> al = new ArrayList<>();
		 
		 int negative=0;
		 for(int i=1 ; i<=(2*al.size()+1) - (2*negative) ; i++) {
			 int a=sc.nextInt(); 
	    	 if(a==-1)     negative++;
			 al.add(a);
		 }
		
		 int arr[] = new int[al.size()];
		 for(int i=0 ; i<al.size(); i++) {
			 arr[i]=al.get(i);
		 }
		  
	 	 BinaryTree3 bt = new BinaryTree3(arr);
	 	 bt.topview();
		
	}

}


class BinaryTree3 {

	class Node{
		int data=0;
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
		
	private Node root=new Node();
			
	BinaryTree3(int arr[]){
		this.makeTree(arr);
	}

	private void makeTree(int [] arr){
			
		Queue<Node> q = new LinkedList<Node>();
		
		this.root.data=arr[0];
		
		int i=1;
		
		q.add(this.root);
		
		while(!q.isEmpty() && i<arr.length) {
			
			Node temp = new Node();
		
			temp=q.poll();
		
			if(arr[i]==-1) {
				i++;
			} else {
				Node left = new Node();
				left.data=arr[i];
				
				q.add(left);
				
				temp.left=left;
				i++;
			}
			
			
			if(arr[i]==-1) {
				i++;
			} else {
				Node right = new Node();
				right.data=arr[i];
				
				q.add(right);
				
				temp.right=right;
				i++;
			}
	
			
		}
	
	
	}

	public void topview() {
		Stack st = new Stack<Integer>();
		st.add(this.root.data);
		
		int present[] = new int[1] ;
		
		present[0]=0;
		topleftview(this.root.left , 0 , present , st);
		
		while(!st.isEmpty()) {
			System.out.print(st.pop()+" ");
		}
		
		present[0]=0;
		toprightview(this.root.right , 0 , present);
	}
	private void topleftview(Node node , int curr , int present[] , Stack<Integer> st) {		
		if(node==null) return;
		if(curr==present[0]) {
			st.add(node.data);
			present[0]++;
		}
		
		if(node.left!=null) 
			topleftview(node.left , curr+1 , present , st);
		
		if(node.right!=null) 
			topleftview(node.right , curr-1 , present , st);
	}
	private void toprightview(Node node , int curr , int[] present) {
		if(node==null) return;
		if(curr==present[0]) {
			System.out.print(node.data+" ");
			present[0]++;
		}
		
		if(node.right!=null) 
			toprightview(node.right , curr+1 , present);
		
		if(node.left!=null) 
			toprightview(node.left , curr-1 , present);
	}
	
	
	
}


//   1 2 3 4 5 6  -1 -1 -1 7 -1 -1 -1 8 -1 9 -1 -1 -1
