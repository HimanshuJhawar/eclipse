package codingBlocks_section6_recursion.recursionPractise;

import java.util.ArrayList;
import java.util.Scanner;

public class OptimalGameStrategy1_Recursion {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();									
		
		ArrayList<Integer> arr= new ArrayList<>();
	
		for(int i=0 ; i<N ; i++)
		{
			int a=sc.nextInt();
			arr.add(a);
		}

		int ans=ogs(arr,0,arr.size()-1 , arr.size());
	
		System.out.println(ans);
		
	}

	
//	static void ogs(int []arr , int p , int n , int s , int e)
//	{
//		if(s>e)
//		{
//			if(resP<p) resP=p;
//			if(resN<n) resN=n;
//			return;
//		}
//		
//		if((e-s)%2==1)
//		{
//			
////			ogs(arr , p+arr[s] , n , s+1 , e);
////			ogs(arr , p+arr[e] , n , s , e-1);
//		}
//		else
//		{
//			
////			ogs(arr , p , n+arr[s] , s+1 , e);
////			ogs(arr , p , n+arr[e] , s , e-1);
//		}
//		
//		
//		
//	}
	
	static int ogs(ArrayList<Integer> arr , int s , int e , int t)
	{
	
		if(t==1) return 0  /*arr.get(s)*/;
		
		
		int piyush=0,p=0,n=0;
		
		
		
		
				if(arr.get(s)>arr.get(e))
				{		
					if(arr.get(e)>arr.get(e-1))
					{
						if(arr.get(s+1)>arr.get(s))
						{
							piyush+=arr.get(e);
							arr.remove(e);
						}
						else
						{
							piyush+=arr.get(s);
							arr.remove(s);
						}
					}
					else
					{
						if(arr.get(s+1)>arr.get(s))
						{
							piyush+=smaller(  arr.get(s+1)-arr.get(s)  ,   arr.get(e-1)-arr.get(e)  );
							arr.remove(  smaller(  arr.get(s+1)-arr.get(s)  ,   arr.get(e-1)-arr.get(e)  )   ) ;
						}
						else
						{
							piyush+=arr.get(s);
							arr.remove(s);
						}
					}
				}
				else
				{
					if(arr.get(s+1)>arr.get(s))
					{
						if(arr.get(e)>arr.get(e-1))
						{
							piyush+=arr.get(e);
							arr.remove(e);
						}
						else
						{
							piyush+=smaller(  arr.get(s+1)-arr.get(s)  ,   arr.get(e-1)-arr.get(e)  );
							arr.remove(  smaller(  arr.get(s+1)-arr.get(s)  ,   arr.get(e-1)-arr.get(e)  )   ) ;
						}
					}
					else
					{
						if(arr.get(e)>arr.get(e-1))
						{
							piyush+=arr.get(e);
							arr.remove(e);
						}
						else
						{
							piyush+=arr.get(s);
							arr.remove(s);
						}
					}				
				}
		
		
		
			if(t%2==0)
			{
				p=piyush;
				n+=ogs(arr,s,arr.size()-1,arr.size());
				if(t>2)
				p+=n;
			}
			else
			{
				n=piyush;
				p+=ogs(arr,s,arr.size()-1,arr.size());
			}
		
		
			return p;
	
	}
	
	
	static int smaller(int m,int n)
	{
		if(m>n) return n;
		else return m;
		
		
	}
	
	
}
