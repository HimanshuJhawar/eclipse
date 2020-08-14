package coding_Blocks.GenericTree_BinaryTree.Questions;
import java.util.*;
public class DeleteNodesFromBST {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		for(int i=1 ; i<=t ; i++) {
			
			int n=sc.nextInt();
			int arr[]=new int[n];
			for(int j=0 ; j<n ; j++)
				arr[j]=sc.nextInt();
			
			DeleteNodesFromBST mn = new DeleteNodesFromBST();
			BST bst=mn.new BST(arr);
			
			int m=sc.nextInt();
			for(int j=1 ; j<=m ; j++) {
				bst.remove(sc.nextInt());
			}
			
			bst.preOrder();
		}
		
		
	}

	public class BST {

		
		private class Node{
			int data;
			Node left=null;
			Node right=null;
		}
		
		
		private Node root = new Node();
		
		
		public BST (int [] arr) {
			this.root.data=arr[0];
			for(int i=1 ; i<arr.length ; i++)
				add(arr[i]);
		}
		
		
		public void add(int item) {
			add(this.root , item);
		}
		private void add(Node node , int item) {

			
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
		
		
		private int[] min(Node node , int mini[]) {
			if(node==null) return mini;
			
			if(node.data<mini[0]) mini[0]=node.data;
			
			mini=min(node.left , mini);
			mini=min(node.right , mini);
			
			return mini;
		}
		public void remove(int item) {			
			remove(this.root , null , false , item);
		}
		private void remove(Node node , Node parent , boolean isleftchild , int item) {
			// left child ke liye true and right child ke liye false rakha hai 
			
			// when given node is not present in the tree , then return
			if(node==null) return;
			
			// first reach on the node from where it is to be removed
			if(item<node.data)
				remove(node.left , node , true , item);
			
			// first reach on the node from where it is to be removed
			else if(item>node.data)
				remove(node.right , node , false , item);
			
			// after reaching on a node to be removed
			else if(item==node.data) {
				// 4 cases are to be taken care
							
				// when node is leaf node
				if(node.left==null && node.right==null) {
					if(isleftchild)
						parent.left=null;
					else 
						parent.right=null;
				}
				
				// when there is tree on right side of a node only
				if(node.left==null && node.right!=null) {
					if(isleftchild)
						parent.left=node.right;
					else
						parent.right=node.right;
				}
				
				// when there is a tree on a left side of a tree only
				if(node.left!=null && node.right==null) {
					if(isleftchild)
						parent.left=node.left;
					else
						parent.right=node.left;
				}
				
				// when there is a tree on both sides of a node
				if(node.left!=null && node.right!=null) {
//					// find max element on a left side of a node
//					int max=max(node.left);
//					
//					// replace node with the max element of a left side of a node
//					node.data=max;
//						
//					// remove that max element from left tree of a node
//					remove(node.left , node , true , max);
					
					int[] a = {Integer.MAX_VALUE};
					int[]b=min(node.right , a);
										
					remove(b[0]);
					
					node.data=b[0];

				}
				
						
			}
			
		}
		
		
	}

	
}
