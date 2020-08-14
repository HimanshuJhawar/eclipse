package codingBlocks_section6_recursion.recursionPrintingCounting;

import java.util.Scanner;

public class Count_N_Queens {

	static int res=0;
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int [][]a=new int[n][n];
		
		countq(a , n , 0 , 0 , "");
		
		System.out.println( res );
		
	}
	
	static void countq(int[][] a , int n , int r , int c , String ans)
	{
		if(r==n)
		{
			res++;
			System.out.println(ans);
			return;
		}

		for(int i=0 ; i<n ; i++)
		{
			if(a[r][i]==0)
			{
				
				a[r][i]=r+1;								// (+1) isliye kar rahe hai taaki zero'th row me value 1 store o naa ki zero , varna confusion ho jaayegi
				changes(a , n , r , i , r+1);
				
				
				countq(a , n , r+1 , 0  , ans+"{ "+(r+1)+" - "+(i+1)+" } ");
			
				
				reversingchanges(a , n , r , i , r+1);
				a[r][i]=0;
			
			}
					
		}
	
	}

	
	
	static void changes(int [][] a , int n , int r , int c , int e)
	{
		
		for(int i=r ; i<n ; i++)
		{
			if(a[i][c]==0)
			a[i][c]=e;
		}
		
		for(int i=0 ; i<n ; i++)
		{
			if(a[r][i]==0)
			a[r][i]=e;
		}
		
		int i=0;
		while(r+i<n && c-i>=0)
		{
			if(a[r+i][c-i]==0)
			a[r+i][c-i]=e;
			i++;
		}
		
		i=0;
		while(r+i<n && c+i<n)
		{
			if(a[r+i][c+i]==0)
			a[r+i][c+i]=e;
			i++;
		}
		
	}
	
	
	
	static void reversingchanges(int[][] a , int n , int r , int c , int e)
	{
		
		for(int i=r ; i<n ; i++)
		{
			if(a[i][c]==e)
			a[i][c]=0;
		}
		
		for(int i=0 ; i<n ; i++)
		{
			if(a[r][i]==e)
			a[r][i]=0;
		}
		
		int i=0;
		while(r+i<n && c-i>=0)
		{
			if(a[r+i][c-i]==e)
			a[r+i][c-i]=0;
			i++;
		}
		
		i=0;
		while(r+i<n && c+i<n)
		{
			if(a[r+i][c+i]==e)
			a[r+i][c+i]=0;
			i++;
		}
		
	}

	
	
}
