package coding_Blocks.DP.Questions;

import java.util.ArrayList;
import java.util.Scanner;

public class O1Knapsack {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int cap=sc.nextInt();
		
		ArrayList<Integer> wt = new ArrayList<>();
		ArrayList<Integer> val = new ArrayList<>();

		for(int i=0; i<n ; i++)
		{
			int temp=sc.nextInt();
			wt.add(temp);
		}
		for(int i=0 ; i<n ; i++)
		{
			int temp=sc.nextInt();
			val.add(temp);
		}
		
		System.out.println(knapsack(wt , val , cap , new int[cap+1]));
		
	}
	
	static int knapsack(ArrayList<Integer> wt , ArrayList<Integer> val , int cap , int[]dp)
	{
		if(cap<=0) return 0;
		
		if(dp[cap]!=0) return dp[cap];
		
		int ans=0,temp=0;
		for(int i=0 ; i<wt.size(); i++)
		{
			int a=wt.remove(i);
			int b=val.remove(i);
			
			if(cap-a>0)
				temp = b+knapsack(wt , val , cap-a , dp);
			
			if(ans<temp)
				ans=temp;
			
			wt.add(i,a);
			val.add(i,b);
		}
		
		dp[cap]=ans;
		return ans;
	}

}
