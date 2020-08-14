package coding_Blocks.cb_Section10_Stacks_OOPS;

import java.util.*;

public class Max_In_Window_Size_K {

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
		
		st.add(0);
		for(int i=0 ; i<k-1 ; i++ )
		{
			if(arr[i]<arr[st.peek()])
				st.add(i);
			else
			{
				while(!st.isEmpty() && arr[i]>=arr[st.peek()])
					st.remove();
				
				st.add(i);
			}
		}
		
		
		
		for(int i=k-1 ; i<arr.length ; i++)
		{
			if(st.peek()<=i-k)
			{
				st.remove();
			}
			
			
			if(arr[i]<arr[st.peek()])
			{
				System.out.println(arr[st.peek()]);
				st.add(i);
			}
			else
			{
				while(!st.isEmpty() && arr[i]>=arr[st.peek()])
					st.remove();
				
				st.add(i);
				System.out.println(arr[st.peek()]);
			}
			
			
		}
		
	}

}
