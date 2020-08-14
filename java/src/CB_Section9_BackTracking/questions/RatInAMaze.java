package CB_Section9_BackTracking.questions;

import java.util.Scanner;

public class RatInAMaze {

	static boolean result=false;
	
	
	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		String space=sc.nextLine();
		char [][] arr=new char[N][M];
		int [][] ans=new int[N][M];

		
		for(int i=0 ; i<N ; i++)
		{
			String forChar=sc.nextLine();

			for(int j=0 ; j<M ; j++)
			{
				arr[i][j]=forChar.charAt(j);
				ans[i][j]=0;
			}
		}
		
		

		
		ratMaze(arr , 0 , 0 , ans);
		if(result==false)
			System.out.println(-1);
				
	}
	
	
	static void ratMaze(char [][] arr , int row , int col , int[][] ans)
	{
		if(row>=ans.length || col>=ans[0].length) return;
		
		
		if(ans[row][col]=='X')	return;

		
		// printing the answer
		if(row==ans.length-1 && col==ans[0].length-1)
		{
			ans[row][col]=1;
			for(int i=0 ; i<=row ; i++)
			{
				for(int j=0 ; j<=col ; j++)
				{
					System.out.print(ans[i][j]+" ");
				}
				
				System.out.println();
			}
			
			result = true;
			System.out.println();
			return;
		}


		if(arr[row][col]=='O'&&result==false)
		{
			ans[row][col]=1;
			ratMaze(arr , row , col+1 , ans);
			ratMaze(arr , row+1 , col , ans);
			ans[row][col]=0;
		}

		
		
		
	}
	
	
	
	
}
