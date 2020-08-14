package coding_Blocks.GenericTree_BinaryTree;

public class BinaryTreeClient {

	public static void main(String[] args) {

		// -50 true 25 true -38 false false true -48 true -18 false false false true 45 true -85 false false true 60 false true 30 false false
		//				 -50
		//		  	25          45
		//		-38    -48  -85    60
		//		   	 -18			  30
		
		// -50 true 25 true 12 false false true 37 false false true -75 true 62 false false true 87 false false
		// 10 true 20 true 40 true 60 false false false true 50 false false true 30 false false
		// 10 true 20 true 40 true 80 false false false true 50 true 100 false false false true 30 true 60 false false true 70 false true 150 false false
		
		BinaryTree tree = new BinaryTree();
	
		tree.display();
		
		System.out.println(tree.height());
		
		tree.preOrder();
		
		tree.postOrder();
		
		tree.inOrder();
		
		tree.levelOrder();
		
		tree.LevelOrderUsingQueue();
		
		tree.bst();
		
		System.out.println(tree.isBST());
		
		System.out.println(tree.diameter());
		
		System.out.println(tree.diameterbetter());
		
		System.out.println(tree.isBalanced());
		
		System.out.println(tree.isBalanced2());
		
		tree.preOrder2();
		
		System.out.println(tree.maxsubsum());
		
		System.out.println(tree.maxsubsum2());
		
		
		
		int [] pre1= {10 , 20 , 40 , 80 , 50 , 100 , 30 , 60 , 70 , 150};
		int [] in1 = {80 , 40 , 20 , 100 , 50 , 10 , 60 , 30 , 70 , 150};
		BinaryTree tree2=new BinaryTree(pre1 , in1);
		tree2.display();
		
		System.out.println();
				
		int pre2[] = {-50 , 25 , -38 , -48 , -18 , 45 , -85 , 60 , 30};
		int in2[]  = {-38 , 25 , -18 , -48 , -50 , -85 , 45 , 60 , 30};
		BinaryTree tree3=new BinaryTree(pre2 , in2);
		tree3.display();
	
	}

}
