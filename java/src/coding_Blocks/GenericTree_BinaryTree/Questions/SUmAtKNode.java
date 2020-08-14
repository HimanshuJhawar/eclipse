package coding_Blocks.GenericTree_BinaryTree.Questions;
import java.util.*;
public class SUmAtKNode {
	
	static Scanner sc=new Scanner(System.in);

    public static void main(String args[]) {
    	
    	SUmAtKNode a = new SUmAtKNode();
		BinaryTree bt = a.new BinaryTree();

		int k=sc.nextInt();
		
		System.out.println(bt.sumAtK(k));



    }

	public class BinaryTree{
		
		class Node{
			int data;
			int noOfChild;
			Node left;
			Node right;
			
			Node(){
				
			}
			
			Node(int data , int noOfChild , Node left , Node right){
				this.data=data;
				this.noOfChild=noOfChild;
				this.left=left;
				this.right=right;
			}
		}      
	
		private int size=0;
		private Node root=new Node();
	
		BinaryTree(){
			this.root=takeInput(this.root);
		}
		              
		private Node takeInput(Node node){
			
			Node n=new Node();
			
			int nodedata=sc.nextInt();
			n.data=nodedata;
	
			int noOfChild=sc.nextInt();
			n.noOfChild=noOfChild;
			
			if(noOfChild==1){
				Node left=new Node();
				n.left=takeInput(left);
			}
			else if(noOfChild==2){
				Node left=takeInput(n);
				Node right = takeInput(n);
				
				n.left=left;
				n.right=right;
			}
	
			return n;
			
		}
	
		public int sumAtK(int k){
			int sum[]= {0};
			sumAtK(this.root , k , 0 , sum);
			return sum[0];
		}
		private void sumAtK(Node node , int k , int curr , int [] sum){
			
			if(node==null) return;
			
			if(k==curr)
				sum[0]+=node.data;
			
			sumAtK(node.left , k , curr+1 , sum);
			sumAtK(node.right , k , curr+1 , sum);
			
			
		}
	
	}

}
