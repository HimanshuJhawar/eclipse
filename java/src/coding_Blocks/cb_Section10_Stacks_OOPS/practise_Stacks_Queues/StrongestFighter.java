package coding_Blocks.cb_Section10_Stacks_OOPS.practise_Stacks_Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class StrongestFighter {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		Deque<Integer> st=new LinkedList<>();
		
		int N=sc.nextInt();
		int arr[]=new int[N];
		for(int i=0 ; i<N ; i++)
			arr[i]=sc.nextInt();
		int k=sc.nextInt();

		st.push(0);
		

		for(int i=1 ; i<arr.length ; i++)
		{
			
			if(arr[st.peek()]<=arr[i])
			{
				while(!st.isEmpty() && arr[st.peek()]<=arr[i])
					st.pop();
				
				st.push(i);
			}
			else
				st.push(i);
			
			while(st.peekLast()<i-(k-1))
				st.pollLast();
		
			if(i>=k-1)
			System.out.print(arr[st.peekLast()]+" ");	
			
		}
		
	}

}
