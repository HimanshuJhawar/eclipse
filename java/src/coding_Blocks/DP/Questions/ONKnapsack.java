package coding_Blocks.DP.Questions;

import java.util.*;

public class ONKnapsack {

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
		
		
//		int ans=0;
//		while(cap>0)
//		{
//			int index=0 ;
//			double max=0;
//			for(int i=0 ; i<val.size() ; i++)
//			{
//				double temp=(double)val.get(i)/wt.get(i);
//				
//				if(temp>max && wt.get(i)<=cap)
//				{
//					max=temp;
//					index=i;
//				}
//			}
//			
//			int numberoftimes = cap/wt.get(index);
//			
//			if(numberoftimes==0) break;
//			
//			ans = ans + numberoftimes * val.get(index);
//			
//			cap = cap - numberoftimes*wt.get(index);
//			
//			wt.remove(index);
//			val.remove(index);
//		}
//		
//		System.out.println(ans);
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Knapsack(cap , wt , val , 0 , new int[cap+1]);
//		System.out.println(max);
		
		System.out.println(Knapsack(cap , wt , val));
	}

//  T.C. is higher	
	private static int max=0;
	static void Knapsack(int cap , ArrayList<Integer> wt , ArrayList<Integer> val , int ans , int [] dp)
	{
		if(cap<0) return;
		
		if(cap==0)
		{
			if(max<ans)
				max=ans;
			return;
		}
		
		
		for(int i=0 ; i<val.size() ; i++)	
		{
			Knapsack( cap-wt.get(i) , wt , val , ans+val.get(i) , dp);		
		}

	}

//  T.C. is lower	
	static int Knapsack(int cap , ArrayList<Integer> wt , ArrayList<Integer> val)
	{
		int []dp = new int[cap+1];
		
		for(int j=0 ; j<=cap ; j++)
		{	
			for(int i=0 ; i<wt.size() ; i++)
			{
				if(j-wt.get(i)>=0)
					dp[j]=Math.max(dp[j] , dp[j-wt.get(i)]+val.get(i));
			}
		}
		
		return dp[cap];
	}




}
