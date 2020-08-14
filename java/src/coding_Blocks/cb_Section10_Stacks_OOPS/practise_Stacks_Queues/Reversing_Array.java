package coding_Blocks.cb_Section10_Stacks_OOPS.practise_Stacks_Queues;

import java.util.Scanner;
import java.util.Stack;

public class Reversing_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		Stack<Integer> obj = new Stack<>();
		Stack<Integer> helper=new Stack<>();
		for(int i=1;i<=N;i++){
			obj.push(sc.nextInt());
		}
				
		reverseStack(obj, helper, 0);
		
		while(!obj.isEmpty())
		System.out.println(obj.pop());
		
		
	}
	
	
	static void reverseStack(Stack<Integer> stack, Stack<Integer> helper, int idx) {
		if(stack.isEmpty())
			return;
		
		int temp=stack.pop();
		reverseStack(stack , helper , idx+1);
		helper.push(temp);
		
		if(idx==0)
		{
			while(!helper.isEmpty())
			stack.push( helper.pop() );
		}

		
	}

}
