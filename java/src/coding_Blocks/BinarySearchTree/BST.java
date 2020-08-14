package coding_Blocks.BinarySearchTree;


public class BST {

	private class Node{
		int data;
		Node left=null;
		Node right=null;
	}
	
	
	private Node root;
	
	
	public BST (int [] inorder) {
		this.root=construct(inorder , 0 , inorder.length-1);
	}
	
	
	private Node construct(int [] inorder , int start , int end) {
	
		if(start>end) return null;
		if(start==end) {
			Node base = new Node();
			base.data=inorder[start];
			return base;
		}
		
		int mid=(start+end)/2;
		
		Node node = new Node();
		
		node.data=inorder[mid];
		
		node.left=construct(inorder , start , mid-1);
		
		node.right=construct(inorder , mid+1 , end);
		
		return node;
		
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
	
	
	public boolean find(int a) {
		return find(this.root , a);
	}
	private boolean find(Node node , int a) {
		
		if(node==null) return false;
		
		if(a==node.data) return true;
		
		else if(a<node.data) {
			boolean search = find(node.left , a);
			return search;
		}
		
		else if(a>node.data) {
			boolean search = find(node.right , a);
			return search;
		}
		
		return false;
		
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

	
	public int max() {
		return max(this.root);
	}
	private int max(Node node) {
		
		if(node.right==null) return node.data;
		
		max(node.right);
		
		return 0;
	}
	
	
	public void remove(int item) {
		remove(this.root , null , false , item);
	}
	private void remove(Node node , Node parent , boolean isleftchild , int item) {
		// left child ke liye true and right child ke liye false rakha hai 
		
		
		// when given node is not present in the tree , then return
		if(node==null) return;
		
		
		// first reach on the node from where it is to be removed
		if(item<node.data) {
			remove(node.left , node , true , item);
		}
		
		// first reach on the node from where it is to be removed
		else if(item>node.data) {
			remove(node.right , node , false , item);
		}
		
		// after reaching on a node to be removed
		else if(item==node.data) {
			// 4 cases are to be taken care
			
			
			// when node is leaf node
			if(node.left==null && node.right==null) {
				if(isleftchild) {
					parent.left=null;
				} else {
					parent.right=null;
				}
			}
			
			
			
			// when there is tree on right side of a node only
			if(node.left==null && node.right!=null) {
				if(isleftchild) {
					parent.left=node.right;
				} else {
					parent.right=node.right;
				}
			}
			
			
			
			// when there is a tree on a left side of a tree only
			if(node.left!=null && node.right==null) {
				if(isleftchild) {
					parent.left=node.left;
				} else {
					parent.right=node.left;
				}
			}
			
			
			
			// when there is a tree on both sides of a node
			if(node.left!=null && node.right!=null) {
				
				// find max element on a left side of anode
				int max=max(node.left);
				
				// replace node with the max element of a left side of a node
				node.data=max;
					
				// remove that max element from left tree of a node
				remove(node.left , node , true , max);
			}
			
					
		}
		
	}
	
	
}
