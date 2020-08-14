package coding_Blocks.DP.Questions;

import java.util.Scanner;

public class PrintLCS {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		String a=sc.nextLine();
		String b=sc.nextLine();
		
		System.out.println(printlcs(a , b));
		
	}
	
	
	static String printlcs(String a , String b )
	{		
		
		String[][] dp = new String[a.length()+1][b.length()+1] ;
		dp[0][0]="";
		
		for(int i=0 ; i<=a.length(); i++)
		{
			for(int j=0 ; j<=b.length(); j++)
			{
				if(i==0 || j==0)
				{
					dp[i][j]="";
					continue;
				}
				
				if(a.charAt(a.length()-i)==b.charAt(b.length()-j))
					dp[i][j]= a.charAt(a.length()-i) + dp[i-1][j-1] ;
				else
				{
					if(dp[i-1][j].length()>dp[i][j-1].length())
						dp[i][j]=dp[i-1][j];
					else
						dp[i][j]=dp[i][j-1];
				}
				
			}
		}
		
//		for(int i=1 ; i<=a.length(); i++)
//		{
//			for(int j=1 ; j<=b.length(); j++)
//				System.out.print(dp[i][j]+" ");
//			System.out.println();
//		}
		
		return dp[a.length()][b.length()];
	}

	
	
}
