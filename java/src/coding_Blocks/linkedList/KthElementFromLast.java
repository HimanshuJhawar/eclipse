package coding_Blocks.linkedList;

import java.util.*;

public class KthElementFromLast {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc=new Scanner(System.in);
		
		LinkedList<Integer> ll = new LinkedList<>();
		
		int x=0;
		while(x!=-1)
		{
			x=sc.nextInt();
			if(x!=-1)
				ll.add(x);
		}
		
		int k=sc.nextInt();
		
		System.out.println(ll.get(ll.size()-k));
		
		
		
		
	}

}
