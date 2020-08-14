package coding_Blocks.cb_Section10_Stacks_OOPS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class First_NegativeNum_Window_K {

	public static void main(String[] args) {

			Scanner sc=new Scanner(System.in);
			
			int n=sc.nextInt();
			int k=sc.nextInt();
			int arr[]= new int[n];
			
			for(int i=0 ; i< n ; i++)
				arr[i]=sc.nextInt();
			
			
			Queue<Integer> st=new LinkedList<>();
			
			FirstNegativeNumber(st , arr , k);
			
	}

	static void FirstNegativeNumber(Queue<Integer> st , int [] arr , int k)
	{
		
		for(int i=0 ; i<k-1 ; i++ )
		{
			if(arr[i]<0)
			{
				st.add(i);
			}
			
		}
		
		
		
		for(int i=k-1 ; i<arr.length ; i++)
		{
			if(st.peek()<=i-k)
			{
				st.remove();
			}
			
			
			if(arr[i]<0)
			{
				st.add(i);

				
				if(!st.isEmpty())
					System.out.println(arr[st.peek()]);
				else
					System.out.println(0);				
			}
			else
			{
				if(!st.isEmpty())
					System.out.println(arr[st.peek()]);
				else
					System.out.println(0);			
			}

		
		
		}
		
	}
	
}
