package coding_Blocks.GenericTree_BinaryTree.Questions;
import java.util.*;
public class PrintInRange {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int i=1 ; i<=t ; i++){
			
			int n=sc.nextInt();
			int in[] = new int[n];
			for(int j=0 ; j<n ; j++)
				in[j]=sc.nextInt();
						
			int k1=sc.nextInt();
			int k2=sc.nextInt();
			
			PrintInRange m=new PrintInRange();
			BST bt = m.new BST(in);
						
			System.out.print("# Preorder : ");
			bt.preOrder();
					
			System.out.print("# Nodes within range are : ");
			bt.inRange(k1 , k2);

		}
		
	}
	
	public class BST {

		private class Node{
			int data;
			Node left=null;
			Node right=null;
		}
		
		
		 private Node root=new Node();
		
		
		public BST (int [] arr) {
			this.root.data=arr[0];
			for(int i=1 ; i<arr.length ; i++)
				add(arr[i]);
		}

		
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
	
		
		
		public void add(int item) {
			add(this.root , item);
		}
		private void add(Node node , int item) {
			
			if(node==null) {
				Node temp = new Node();
				temp.data=item;
				node=temp;
				return;
			}
			
			
			if(item<node.data && node.left!=null) {
				add(node.left , item);
			}
			else if(item<node.data && node.left==null) {
				Node added = new Node();
				added.data=item;
				node.left=added;
				
				return;
			}
			
			
			if(item>node.data && node.right!=null) {
				add(node.right , item);
			}
			else if(item>node.data && node.right==null) {
				Node added = new Node();
				added.data=item;
				node.right=added;
				
				return;
			}
			
		}

		
		
		public void inRange(int k1 , int k2) {
			this.inRange(this.root , k1 , k2);
			System.out.println();
		}
		private void inRange(Node node , int k1 , int k2) {
			
			if(node==null) return;
			
			if(node.data<k1)
				inRange(node.right , k1 , k2);
			
			if(node.data>k2)
				inRange(node.left , k1 , k2);
			
			if(node.data<=k2 && node.data>=k1) {
				
				inRange(node.left , k1 , k2);
				
				System.out.print(node.data+" ");
				
				inRange(node.right , k1 , k2);
			}
			
		}
		
		
		
	}		

}
