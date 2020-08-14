package codingBlocks_section6_recursion.recursionPractise;

import java.util.Scanner;

public class RemoveDuplicateCharacter {

	public static void main(String[] args) {


		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
				
		String ans=rdc(s,1);
		System.out.println(ans);
   }
	
	
	static String rdc(String s , int a)
	{
		if(a>=s.length()) return s;

		
		if( (s.charAt(a)!=s.charAt(a-1))  )s=rdc(s,a+1);
		else 
		{
			s=s.substring(0,a)+"*"+s.substring(a);
			s=rdc(s,a+2);
		}
		
		return s;
		
		
	}

}
