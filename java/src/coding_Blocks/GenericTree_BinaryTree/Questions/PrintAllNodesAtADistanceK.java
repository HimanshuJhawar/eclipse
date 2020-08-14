package coding_Blocks.GenericTree_BinaryTree.Questions;

import java.util.*;
public class PrintAllNodesAtADistanceK {


	class Node {
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

	private Node root;
	private int size;

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
		
	//	if(preS+1<=preS+i && inS<=i-1)
		curr.left = pre_in_generate(pre , preS+1 , preS+i , in , inS , i-1);
		
	//	if(preS+i+1<=preE && i+1<=inE)
		curr.right = pre_in_generate(pre , preS+i+1 , preE , in , i+1 , inE);
		
		return curr;
	}

	
	public void distNode(Node node , int val , int k){
		distNode(node , val , k , this.root);
	}
	private void distNode(Node node , int val , int k , Node root) {
		
	}


	

    public static void main(String args[]) {

		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();

		int [] pre=new int[n];
		for(int i=0 ; i<n ; i++){
			pre[i]=sc.nextInt();
		}

		int in[]=new int[n];
		for(int i=0 ; i<n ; i++){
			in[i]=sc.nextInt();
		}

		int T=sc.nextInt();

		for(int i=1 ; i<=T ; i++){
			
			int nodeVal=sc.nextInt();
			int k=sc.nextInt();


			PrintAllNodesAtADistanceK tree=new PrintAllNodesAtADistanceK();

			Node root = tree.pre_in_generate(pre , 0 , n , in , 0 , n);
			
			tree.distNode(root , nodeVal , k);
			
		}



    }
}
