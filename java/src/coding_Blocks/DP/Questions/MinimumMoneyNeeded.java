package coding_Blocks.DP.Questions;

import java.util.Scanner;

public class MinimumMoneyNeeded {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int W=sc.nextInt();
		
		int val[] = new int[N+1];
		
		for(int i=1 ; i<=N ; i++)
			val[i]=sc.nextInt();
		
		int wt[] = new int[N+1];
		for(int i=1 ; i<=N ; i++)
			wt[i]=i;
		
		System.out.println(minmoney(N , W , wt , val));
		
	}

	static int minmoney(int n , int w , int[] wt , int []val)
	{
		int []dp=new int[w+1];
		dp[0]=0;
		for(int i=1 ; i<dp.length ; i++)
			dp[i]=Integer.MAX_VALUE;
		
		
		for(int i=1 ; i<=w ; i++)
		{

			for(int j=1 ; j<val.length ; j++)
			{
				if(val[j]==-1) continue;
				
				if(i-wt[j]>=0)
					dp[i] = Math.min(dp[i] , dp[i-wt[j]] + val[j]);
			}
		
		}
		
		if(dp[w]==Integer.MAX_VALUE) 
			return -1;
		
		return dp[w];
	}
	
}
