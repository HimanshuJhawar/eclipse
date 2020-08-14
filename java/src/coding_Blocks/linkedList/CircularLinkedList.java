package coding_Blocks.linkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class CircularLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		LinkedList<Integer> ll=new LinkedList<>();
		
		ll.add(0);
		int x=0;
		while(ll.getLast()!=-1 && x!=-1)
		{
			x=sc.nextInt();
			if(!ll.contains(x) && x!=-1)
			{
				System.out.println(x);
				ll.add(x);
			}
			
		}
		
	}

}
