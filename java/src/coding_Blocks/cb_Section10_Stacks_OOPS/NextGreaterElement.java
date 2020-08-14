package coding_Blocks.cb_Section10_Stacks_OOPS;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {

		
		Stack<Integer> st=new Stack<>();
		

		int []arr= {2,1,3,8,6,7,5};
		int n=arr.length;
		int i=n-1;
		
		// starting from last of array
		while(i>=0)														
		{
			// checking the next element , if its not greater
			// we pop it , because no use of that element
			while( st.size()>0 && st.peek()<arr[i] )					
				st.pop();
			
			
			// for starting position
			if(st.size()==0)											
			{
				System.out.println(arr[i] + " - "+ 0);
				st.push(arr[i]);
			}
			
			
			// if peek element is greater then that element is 
			// next greater element and we print it and push current element
			if(arr[i]<st.peek())										
			{
				System.out.println(arr[i]+" - "+st.peek());
				st.push(arr[i]);
			}
			
			i--;
			
		}
		
		
	}

}
