package coding_Blocks.Heap;

import java.util.*;

public class TopKMostFreqElement {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
				
		int t=sc.nextInt();
		for(int i=1 ; i<=t ; i++) {
		
			PriorityQueue<Node> q = new PriorityQueue<>();
			int n=sc.nextInt();
			int k=sc.nextInt();
			
			int a[]=new int[n];
			for(int j=0; j<n ; j++)
				a[j]=sc.nextInt();
			
			
			
		}
		
	}
	
	class Node implements Comparable{
		int data;

		HashMap<Integer , Integer> hm=new HashMap<>();
		Node(){
			
		}
		
		Node(int data , int freq){
			this.data=data;
			hm.put(data , freq);
		}

		@Override
		public int compareTo(Object o) {
			
			return 0;
		}
	}

	
}
