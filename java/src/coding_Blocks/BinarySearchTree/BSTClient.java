package coding_Blocks.BinarySearchTree;

import java.util.*;

public class BSTClient {

	public static void main(String[] args) {
		
		int a[] = {4,3,2,5,6};
		Arrays.sort(a);
		BST tree = new BST(a);
		
		tree.preOrder();
	}

}
