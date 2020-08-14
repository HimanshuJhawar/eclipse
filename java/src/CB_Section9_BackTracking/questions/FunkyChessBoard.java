package CB_Section9_BackTracking.questions;

import java.util.Scanner;

public class FunkyChessBoard {
	
	
	static boolean [][] ans=new boolean[11][11];
	static int res=0;

	public static void main(String[] args) {

		
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [][] cb=new int[N][N];
		
		int total=0;
		
		for(int i=0 ; i<N ; i++)
		{
			for(int j=0 ; j<N ; j++)
			{
				cb[i][j]=sc.nextInt();
				
				if(cb[i][j]==0)
					ans[i][j]=true;
				else
					total++;
			}
		}
		
		fcb(cb , 0 , 0 , 0);
	
		System.out.println(total-res);
		
	}

	static void fcb(int[][] cb , int row , int col , int count)
	{
		
		if(row>=cb.length || col>=cb[0].length || row<0 || col<0 || ans[row][col]==true) return;
		
		res=max(res,count+1);
		
		ans[row][col]=true;	
				
				fcb(cb , row-2 , col-1 , count+1);

				fcb(cb , row-2 , col+1 , count+1);

				fcb(cb , row+2 , col-1 , count+1);

				fcb(cb , row+2 , col+1 , count+1);

				fcb(cb , row-1 , col-2 , count+1);

				fcb(cb , row-1 , col+2 , count+1);

				fcb(cb , row+1 , col-2 , count+1);

				fcb(cb , row+1 , col+2 , count+1);

		ans[row][col]=false;
		
		
	}
	
	
	static int max(int a , int b)
	{
		if(a>b) return a;
		else return b;
	}
	
}
