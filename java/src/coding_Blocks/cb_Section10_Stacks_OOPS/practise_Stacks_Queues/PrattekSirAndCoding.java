package coding_Blocks.cb_Section10_Stacks_OOPS.practise_Stacks_Queues;

import java.util.Scanner;

public class PrattekSirAndCoding {

	 static Scanner s = new Scanner(System.in);
		public static void main(String args[]) throws Exception {
			// Your Code Here
		
		
		    int q = s.nextInt();
		    PrattekSirAndCoding obj = new PrattekSirAndCoding();
	        StacksUsingArrays stack = obj.new StacksUsingArrays();
	    	Calculate(stack, q);
		}

		public static void Calculate(StacksUsingArrays st, int q) throws Exception {
	 
	       //Write Your Code Here
	       /* Donot initialize another Scanner use the static scanner already declared*/

			int arr[]=new int[2*q];
			
			int j=0;
			for(int i=1 ; i<=q ; i++)
			{
				arr[j]=s.nextInt();
				
				if(arr[j]==2)
				{
					j++;
					arr[j]=s.nextInt();
					if(arr[j]==1)
						q--;
					j++;
				}
				else
				{
					j++;
				}	
			}
			
			 int i=0;
			 while(arr[i]!=0)
			 {
			 	if(arr[i]==2 && arr[i+1]!=1)
			 	{
			 		i++;
			 		st.push(arr[i]);
			 		i++;
			 	}
			 	else if(arr[i]==2 && arr[i+1]==1)
			 	{
//			 		System.out.println("No Code");
			 		i++;
			 	}
			 	else 
			 	{
			 		if(st.size()!=0)
			 			System.out.println(st.pop());
			 		else
			 			System.out.println("No Code");
			 		i++;
			 	}
			 }


		}

		private class StacksUsingArrays {
			private int[] data;
			private int tos;

			public static final int DEFAULT_CAPACITY = 10;

			public StacksUsingArrays() throws Exception {
				// TODO Auto-generated constructor stub
				this(DEFAULT_CAPACITY);
			}

			public StacksUsingArrays(int capacity) throws Exception {
				if (capacity <= 0) {
					System.out.println("Invalid Capacity");
				}
				this.data = new int[capacity];
				this.tos = -1;
			}

			public int size() {
				return this.tos + 1;
			}

			public boolean isEmpty() {
				if (this.size() == 0) {
					return true;
				} else {
					return false;
				}
			}

			public void push(int item) throws Exception {
				if (this.size() == this.data.length) {
				    
				    int[] temp = new int[2 * data.length];
				    for(int i = 0;i < data.length;i++){
				        temp[i] = data[i];
				    }
				    
				    data = temp;
				}
				this.tos++;
				this.data[this.tos] = item;
			}

			public int pop() throws Exception {
				if (this.size() == 0) {
					throw new Exception("Stack is Empty");
				}
				int retVal = this.data[this.tos];
				this.data[this.tos] = 0;
				this.tos--;
				return retVal;
			}

			public int top() throws Exception {
				if (this.size() == 0) {
					throw new Exception("Stack is Empty");
				}
				int retVal = this.data[this.tos];
				return retVal;
			}

			public void display() throws Exception {
				if (this.size() == 0) {
					throw new Exception("Stack is Empty");
				}
				for (int i = this.tos; i >= 0; i--) {
					System.out.println(this.data[i]);
				}

			}

		}

	
	
}
