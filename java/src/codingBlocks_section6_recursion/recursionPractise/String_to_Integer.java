package codingBlocks_section6_recursion.recursionPractise;

import java.util.*;

public class String_to_Integer {

	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		System.out.println(sti(s , s.length() -1));
		
	}

	
	static int sti(String s , int n)
	{
		if(n==-1) return 0;
		char c;
		int ans;
		
		c=s.charAt(n);
		ans=sti(s , n-1);
		
		ans=ans*10+(int)c-(int)'0';
		
		return ans;
		
	}
	
}
