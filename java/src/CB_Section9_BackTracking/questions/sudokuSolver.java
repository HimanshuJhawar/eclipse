package CB_Section9_BackTracking.questions;

import java.util.Scanner;

public class sudokuSolver {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int [][]arr=new int[n][n];
		
		for(int i=0 ; i<n ; i++)
		{
			for(int j=0 ; j<n ; j++)
				arr[i][j]=sc.nextInt();			
		}

		solveSudoku(arr , 0 , 0);
	}
	
	
	//  i , j , are for iterations
	static void solveSudoku(int[][] arr , int i , int j)				
	{
		
		//  code will reach here only when sudoku is solved
		if(i==arr.length)									
		{		
			for(int k=0 ; k<arr.length ; k++)
			{
				for(int l=0 ; l<arr.length ; l++)
				System.out.print(arr[k][l]+" ");
				System.out.println();
			}
			
			return;
		}
		
				
		//  entering loop
		while(j<arr.length)
		{
		
			// if element is already there then we dont need to change it
			if(arr[i][j]==0)
			{
				
				// trying for every number
				for(int k=1 ; k<=9 ; k++)
				{
					
					// if (k) is present or not at i'th row
					boolean presentR=searchRow(arr , i , k);
					
					// if (k) is present or not at j'th column
					boolean presentC=searchColumn(arr , j , k);
					
					// if (k) is present or not in 3*3 grid
					boolean presentG=search3_3Grid(arr , i , j , k);
					
					// if not present then fill element
					if(!presentR && !presentC && !presentG)
					{
						arr[i][j]=k;
						
						// moving to next column
						solveSudoku(arr , i , j+1);
						
						// backtracking , reversing every change we made
						arr[i][j]=0;
						
					}
					
				}
				
				// if no element was suitable for filling , 
				// we return to previous column and change that element
				if(arr[i][j]==0) return;
			}
			
			j++;
		
		}
		
		
		// i'th row is filled , moving to i+1'th row
		if(j==arr.length)
		{
			solveSudoku(arr , i+1 , 0);
			return;
		}
		
	}
	
	
	// searching element in row
	static boolean searchRow(int [][] arr , int i , int k)
	{
		boolean present =false;
		
		for(int l=0 ; l<9 ; l++)
		{
			if(arr[i][l]==k)
			{
				present=true;
				break;
			}
		}
		
		return present;
		
	}
	
	
	// searching element in column
	static boolean searchColumn(int[][] arr , int j , int k)
	{
		boolean present =false;
		
		for(int l=0 ; l<9 ; l++)
		{
			if(arr[l][j]==k)
			{
				present=true;
				break;
			}
		}
		
		return present;
	}

	
	// searching element in 3*3 grid
	static boolean search3_3Grid(int [][] arr , int i , int j , int k)
	{
		boolean present =false;
		
		for(int l=(i-i%3) ; l<3+(i-i%3) ; l++)
		{
			for(int m=(j-j%3) ; m<3+(j-j%3) ; m++)
			{
				if(arr[l][m]==k)
				{
					present = true;
					break;
				}
		
			}
		}
		
		return present;
	}

	
}
