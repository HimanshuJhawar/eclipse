package coding_Blocks.GenericTree_BinaryTree.Questions;
import java.util.*;

		// 20 8 22 5 3 4 25 -1 -1 10 14 -1 -1 -1 -1 -1 -1 -1 -1

public class BottomView {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);		
		ArrayList<Integer> al = new ArrayList<>();
		 
		 int negative=0;
		 for(int i=1 ; i<=(2*al.size()+1) - (2*negative) ; i++) {
			 int a=sc.nextInt(); 
	    	 if(a==-1)     negative++;
			 al.add(a);
		 }
		
		 int arr[] = new int[al.size()];
		 for(int i=0 ; i<al.size(); i++) {
			 arr[i]=al.get(i);
		 }

		 BottomView m = new BottomView();
	 	 Tree bt = m.new Tree(arr);
	 	 bt.BottomView();
	}

	private class Tree {
	
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
				
		Tree(int arr[]){
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
	
		public void BottomView(){
			// at each level , value will be stored in hashmap
			HashMap<Integer , Integer[]> m=new HashMap<>();
			
			// filling the hash map
			this.BottomView(this.root , m , 0 , 0);
			
			// taking all the keys , i.e. all the horizontal level
			Set< Map.Entry<Integer , Integer[]> > entries = m.entrySet();
			int a[]=new int[m.size()];
			int i=0;
			
			// filling array with all possible levels
			for( Map.Entry<Integer , Integer[]> entry:entries) {
				a[i]=entry.getKey();
				i++;
			}
			
			// sorting horizontal levels , i.e. from left to right
			Arrays.sort(a);
			
			for(int j=0 ; j<a.length ; j++)
			{
				// getting value at horizontal levels and printing
				Integer z=m.get(a[j])[0];
				System.out.print( z+" " );
			}
		}
	 	private void BottomView(Node node, HashMap<Integer , Integer[]> m , int position , int downheight) {
			
	 		// new horizontal level
	 		if(m.get(position)==null)
	 		{
	 			Integer[] a= {node.data , downheight};
	 			m.put(position , a);
	 		}
	 		// once we have already visited this position , so we 
	 		// need to check which node to be filled at this position
	 		else if(m.get(position)[1]<=downheight)
	 		{
	 			Integer[] a= {node.data , downheight};
	 			m.put(position , a);
	 		}
	 		
			// base case
			if(node.left==null && node.right==null) return;
			
			// moving left
			if(node.left!=null)
				BottomView(node.left , m , position-1 , downheight+1);
			
			// moving right
			if(node.right!=null)
				BottomView(node.right , m , position+1 , downheight+1);
			
		}

	 	
	}
	
	
}
