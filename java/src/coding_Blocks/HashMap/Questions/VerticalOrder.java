package coding_Blocks.HashMap.Questions;
import java.util.*;

	// 1 2 3 4 5 6  -1 -1 -1 -1 -1 -1 -1


public class VerticalOrder {

	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
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

	 	 BinaryTree bt = new BinaryTree(arr);
	 	 
	 	 bt.display();
	 	 bt.VerticalOrder();
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

	public void VerticalOrder(){
		
		HashMap<Integer , String> m=new HashMap<>();
		
		this.VerticalOrder(this.root , m , 0);
		
		Set< Map.Entry<Integer , String> > entries = m.entrySet();
		int a[]=new int[m.size()];
		int i=0;
		
		for( Map.Entry<Integer , String> entry:entries) {
			a[i]=entry.getKey();
			i++;
		}
		
		Arrays.sort(a);
		
		for(int j=0 ; j<a.length ; j++)
		{
			String print=m.get(a[j]);
//			System.out.println(m.get(a[j]));
			System.out.println( m.get(a[j]).charAt(print.length()-2) );
		}
	}
 	private void VerticalOrder(Node node, HashMap<Integer , String> m , int position) {
		
		String s="";
		if(m.get(position)!=null)
			s=s+m.get(position);
		
		m.put(position , s+node.data+" ");
		
		// base case
		if(node.left==null && node.right==null) return;
		
		if(node.left!=null)
			VerticalOrder(node.left , m , position-1);
		
		if(node.right!=null)
			VerticalOrder(node.right , m , position+1);

		
	}

	public void display() {
		this.display(this.root);
	}
	private void display(Node node) {
		
		
		
		String str="";
		
		if(node.left!=null) {
			str=str+node.left.data+" => ";	
		} else {
			str=str+"END => ";
		}
		
		str=str+node.data;
		
		if(node.right!=null) {
			str=str+" <= "+node.right.data;	
		} else {
			str=str+" <= END";
		}
		
		System.out.println(str);
		
		if(node.left!=null) {
			this.display(node.left);
		}
		
		if(node.right!=null) {
			this.display(node.right);
		}

		
		
		
	

}


}



