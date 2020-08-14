package coding_Blocks.cb_Section10_Stacks_OOPS.practise_Stacks_Queues;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0 ; i<n ; i++)
			arr[i]=sc.nextInt();
		
		Stack<Integer> st=new Stack<>();
		
		int ans[]=new int[n];
		
		st.push(0);
		ans[0]=1;
		for(int i=1 ; i<n ; i++)
		{
			ans[i]=1;
			
			if(arr[i]<arr[st.peek()])
			{
				ans[i]=1;
				st.push(i);
			}
			else
			{
				while(!st.isEmpty() && arr[i]>=arr[st.peek()])
				{
					ans[i]+=ans[st.peek()];
					st.pop();
				}
				
				st.push(i);
			}
			
		}
			
		
		for(int i:ans)
			System.out.print(i+" ");
		
		System.out.println("END");
	
		
	}

}
