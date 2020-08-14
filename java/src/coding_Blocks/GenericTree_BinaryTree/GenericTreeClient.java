package coding_Blocks.GenericTree_BinaryTree;

public class GenericTreeClient {

	// 600 3 41 2 17 0 16 0 15 1 21 0 24 2 33 0 84 1 33 1 36 1 23 0
	
	public static void main(String[] args) {

		GenericTree tree=new GenericTree();
		
		tree.display();
		
		System.out.println(tree.size);
		
		System.out.println( tree.size() );
		
		System.out.println(tree.max());
		
		System.out.println(tree.find(21));
		
		System.out.println(tree.height());
	}

}
