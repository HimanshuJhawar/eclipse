package coding_Blocks.DP.Questions;

import java.util.Scanner;

public class WildCardPatternMatching {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		String b=sc.next();

		System.out.println(Matching(a,b , new int[a.length()+1][b.length()+1] , a.length() , b.length()));
		
		
	}

	static int Matching(String a , String b , int[][] dp , int lengthA , int lengthB)
	{
		// when both are empty return true i.e. 1
		if(a.length()==0 && b.length()==0) return 1;
		
		// when b is empty but a is not empty return false i.e. 0
		if(b.length()==0 && a.length()!=0) return 0;
		
		// when a is empty , check b contains only (*) char or any else character and return accordingly
		if(a.length()==0 && b.length()!=0)
		{
			for(int i=0 ; i<b.length() ; i++)
			{
				if(b.charAt(i)=='*')
					continue;
				else
					return 0;
			}
			return 1;
		}

		
		
		// creating dp condition
		if(dp[lengthA-a.length()+1][lengthB-b.length()+1]!=0)
			return dp[lengthA-a.length()+1][lengthB-b.length()+1];
		
		
		// first characters
		char c=a.charAt(0) ;
		char d=b.charAt(0) ;
		int ans=0;
		
		
		// if char are same or (?) go to next character of string
		if(d==c || d=='?') 
			ans=Matching(a.substring(1) , b.substring(1) , dp , lengthA , lengthB);
		else if(d=='*') 
		{
			
			// check if next character is also (*) or not and length of string should be more than 1 to check
			if(b.length()!=1 && b.charAt(1)=='*')
			{
				ans=Matching(a , b.substring(1) , dp , lengthA , lengthB);
			}
			// check for both condition
			// 1) if (*) is used for empty string or
			// 2) it is used for sequence of characters
			else
			{
				// for empty string
				ans=Matching(a , b.substring(1) , dp , lengthA , lengthB);
				// for sequence of characters
				int ans2=Matching(a.substring(1) , b , dp , lengthA , lengthB);
				
				// if anyone is true , then real ans is true , so take max of 0 and 1
				ans=Math.max(ans , ans2);	
			}
		} 
		else		
			return 0;
		
		
		
		dp[lengthA-a.length()+1][lengthB-b.length()+1]=ans;
		return ans;
	}

	
	
}



