package coding_Blocks.cb_Section10_Stacks_OOPS.practise_Stacks_Queues;

import java.util.*;

public class FindTheGreaterElement {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		Stack<Integer> st=new Stack<>();
		
		int n=sc.nextInt();
		// array to take elements
		int arr[]=new int[n];
		
		// array to store ans 
		int ans[]=new int[n];
		
		for(int i=0 ; i<n ; i++)
			arr[i]=sc.nextInt();
		
		// push first element index
		st.push(0);
		
		// to make circular array condition possible
		boolean check=true;
		
		// entering loop
		for(int i=1 ; i<=n ; i++)
		{
			
			// condition for making circular array
			if(i>n-1)
			{
				i=i%n;
				check=false;
			}
			
			
			// if element is bigger than st.peek() , then save results for stored
			// elements on stack in the ans array and pop them and then push  
			// the current element , i.e , i'th element
			if(arr[i]>arr[st.peek()])
			{
				
				// storee result in answer array
				while(!st.isEmpty() && arr[i]>arr[st.peek()] && i!=st.peek())
				{	
					// st.peek() is index of the element for which 
					// result will be stored
					ans[st.peek()]=arr[i];
					st.pop();
				}
				
				// if element after iteration passes the current 
				// index , i.e , the current index is st.peek() 
				if(!st.isEmpty() && i>=st.peek() && !check)
					break;
				
				// push the current element in stack
				if(check)
					st.push(i);
			}
			
			// if next element is smaller or equal store in stack
			else if(arr[i]<=arr[st.peek()])
			{
				// to check that element which we are storing
				// should not be stored again
				if(check)
					st.push(i);
				
				// if element after iteration passes the current 
				// index , i.e , the current index is st.peek() 
				if(check==false && i>=st.peek()-1)
					break;
			}
			
		}
		
		
		// assigning -1 to those present in stack
		while(!st.isEmpty())
		{	
			ans[st.peek()]=-1;
			st.pop();
		}
		
		
		
		// printing result
		for(int i:ans)
			System.out.print(i+" ");

		
	}


	
	
}
