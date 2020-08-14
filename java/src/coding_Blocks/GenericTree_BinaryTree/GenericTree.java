package coding_Blocks.GenericTree_BinaryTree;

import java.util.*;

public class GenericTree {

	private class Node{
		
		int data;
		ArrayList<Node> children ;
		
		Node(int data){
			this.data=data;
			this.children=new ArrayList<>();
		}
		
	}


	private Node root;
	public int size;
	
	
	// making generic tree in the constructor only
	GenericTree(){
		Scanner sc=new Scanner(System.in);
		this.root=takeInput(sc , null , 0);
	}
	
	
	// to take the input of the generic tree
	private Node takeInput(Scanner sc , Node parent , int ithChild) {
		
		if(parent==null) {
			System.out.println("Enter the data for the root node");
		} else {
			System.out.println("Enter the data for the " + ithChild + "th child of " + parent.data);
		}
		
		
		int nodedata=sc.nextInt();
		Node node=new Node(nodedata);
		this.size++;

		
		System.out.println("Enter the no of chldren for " + node.data);
		int children=sc.nextInt();
		
		
		for(int i=0; i<children ; i++) {
			Node child=takeInput(sc , node , i);
			node.children.add(child);
		}
		
		
		return node;
	}

	
	public void display() {
		this.display(this.root);
	}
	private void display(Node node) {
		
		if(node==null) return;
		
		String s="";
		
		s=s+node.data+"=> ";
		
		for(int i=0 ; i<node.children.size() ; i++) {
			s=s+node.children.get(i).data+", "   ;
		}

		s=s+"END";
		
		System.out.println(s);
		
		for(int i=0 ; i<node.children.size() ; i++) {
			display(node.children.get(i));
		}
		
	}


	public int size() {
		return this.size(this.root);
	}
	private int size(Node node) {
				
		int myans=0;
		
		for(int i=0 ; i<node.children.size(); i++) {
			myans+=size(node.children.get(i));
		}
		
		return myans+1;
	}

	
	public int max() {
		return this.max(this.root);
	}
	private int max(Node node) {
		
		if(node==null)
			return Integer.MIN_VALUE;
		
		int myans=node.data;
		
		for(int i=0 ; i<node.children.size() ; i++) {
			myans=Math.max( max(node.children.get(i)) , myans );
		}
		
		return myans;
		
	}


	public boolean find(int search) {
		return this.find(this.root , search);
	}
	private boolean find (Node node , int search) {
		
		if(node.data==search) {
			return true;
		} else {
			for(int i=0 ; i<node.children.size(); i++) {
				boolean res=find(node.children.get(i) , search);
				if(res==true) return true;
			}
		}
		
		return false;
	}

	
	public int height() {
		return this.height(this.root) ;
	}
	private int height(Node node) {
		
		int max=0;
		
		for(int i=0 ; i<node.children.size() ; i++) {
			int ch=height(node.children.get(i));
			
			if(max<ch)
				max=ch;
		}
		
		// height of leaf node is 0
		if(node.children.size()==0) return max;
		
		return max+1;
	}
	
	
	
	
}
