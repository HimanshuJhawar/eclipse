package codingBlocks_section6_recursion.recursionPractise;

import java.util.Scanner;

public class TilingProblem {

	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=1 ; i<=T ; i++)
		{
			int N=sc.nextInt();
			int M=sc.nextInt();						
			
			int arr[]=new int[N+1];
			
			
			arr[0]=0;
			arr[1]=1;
			
			for(int j=2 ; j<=N ; j++)
			{
				if(M>j) arr[j]=1;
				
				else if(M==j) arr[j]=2;
				
				else  arr[j]=(arr[j-1]+arr[j-M])%1000000007;	
			}
			
			System.out.println(arr[N]);
			
//			System.out.println(tp(N,M));			
		}
		
		
	}
	
//	static int tp(int n , int m)								// this is also a correct way but a longer time taking way
//	{
//		if(m>n) return 1;
//		
//		return tp(n-1 , m)/* for horizontal bars*/ + tp(n-m , m)/* for vertical bars*/ ;
//		
//		
//	}

}
