package coding_Blocks.cb_Section10_Stacks_OOPS;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		Stack<Character> st=new Stack<>();
		
		String s=sc.nextLine();
		char c='0';
		int i=0;
		
		while(i<s.length())
		{
			if(s.charAt(i)=='(')
				st.push(')');
			
			else if(s.charAt(i)=='{')
				st.push('}');
			
			
			
			if(s.charAt(i)==')' && st.empty())
			{
				c='f';
				break;
			}
			else if(s.charAt(i)=='}' && st.empty())
			{
				c='f';
				break;
			}
			
			
			
			
			if(  !st.empty() && s.charAt(i)==st.peek() )
				c=st.pop();
			
			
			
			
			i++;
		}
		
		
		if(st.empty() && c!='f')
			System.out.println("true");
		else
			System.out.println("false");
		
				
	}

}
