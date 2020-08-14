package coding_Blocks.GenericTree_BinaryTree.Questions;
import java.util.*;

public class TreeLeftView {

	 public static void main(String args[]) {
		 
		 Scanner sc=new Scanner(System.in);
		 ArrayList<Integer> al = new ArrayList<>();
		 
		 int negative=0;
		 for(int i=1 ; i<=(2*al.size()+1)-(2*negative) ; i++) {
			 int a=sc.nextInt(); 
	    	 if(a==-1)     negative++;
			 al.add(a);
		 }
		
		 Object [] o = al.toArray();
		 int [] a=new int[o.length];
		 
		 for(int i=0 ; i<o.length ; i++) {
			 a[i]=(int)o[i];
		 }
		
		 
		 
	 	 BinaryTree bt = new BinaryTree(a);
	 	 bt.leftview();
	 
	 }

}


class BinaryTree {

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
			
	BinaryTree(int arr[]){
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
		
	int present=0;
	public void leftview() {
		this.leftview(this.root , 0);
	}
	private void leftview(Node node , int curr) {
		
		if(node==null) return;
		
		if(present<=curr) {
			System.out.print(node.data+" ");
			present++;
		}
		
		if(node.left!=null) {
			leftview(node.left , curr+1);
		}  
		
		if(node.right!=null) {
			leftview(node.right , curr+1);
		}
		
		
		
	}
	
}

	
	
	
	
	
	

