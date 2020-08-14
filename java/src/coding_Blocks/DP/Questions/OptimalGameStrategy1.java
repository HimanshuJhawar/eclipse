package coding_Blocks.DP.Questions;

import java.util.Scanner;

public class OptimalGameStrategy1 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0 ; i<n ; i++)
			arr[i]=sc.nextInt();
		
		System.out.println(ogs1(arr , 0 , n-1 , new int[n][n]));
		
	}

	static int ogs1(int[] arr , int start , int end , int[][]dp)
	{
		if(start==end) return arr[start];
		if(start>end) return 0;
		
		if(dp[start][end]!=0) return dp[start][end];
		
		int ans = Math.max( arr[start] + Math.min( ogs1(arr,start+2,end,dp) , ogs1(arr,start+1,end-1,dp) ) 
							, arr[end] + Math.min( ogs1(arr,start+1,end-1,dp) , ogs1(arr,start,end-2,dp) ) );
		
		dp[start][end]=ans;
		return ans;
	}

	
}
