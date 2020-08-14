package coding_Blocks.cb_Section10_Stacks_OOPS.practise_Stacks_Queues;

import java.util.Scanner;
import java.util.Stack;

public class Redundant_Parenthesis {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		String space=sc.nextLine();

		for(int i=1 ; i<=n ; i++)
		{
			String s=sc.nextLine();

			Stack<Integer> st=new Stack<>();
			
			balancedP(st , s , 1);
		}
			
			
	}
	
	static void balancedP(Stack<Integer> st , String s , int counter)
	{
		if(s.charAt(0)=='(')
			st.push(1);
		
		for(int i=1 ; i<s.length(); i++)
		{
			if(s.charAt(i-1)!='(' && s.charAt(i)=='(')
				st.push(1);
			else if(s.charAt(i-1)=='(' && s.charAt(i)=='(')
				st.push(st.peek()+1);

		
			if(i!=s.length()-1 && s.charAt(i)==')' && s.charAt(i+1)==')'  && st.peek()>1)
			{
				System.out.println("Duplicate");
				break;
			}
			else if(s.charAt(i)==')')
				st.pop();
		
		}
		
		if(st.isEmpty())
			System.out.println("Not Duplicates");

	}

	
	
}
