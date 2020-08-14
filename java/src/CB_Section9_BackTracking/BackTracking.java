 package CB_Section9_BackTracking;

public class BackTracking {

	
	
	static int i=0;
	
	
	
	public static void main(String[] args) {

		
		boolean [] box=new boolean[4];
		
		String [] board=new String[4];
		
		
//		QueenCombinationAndPermutation(box , 2 , 0 , "");
//		System.out.println();
//		
//		
//		QueenPermutation(board , 2 , 0);   				// another method of queen permutation
//		System.out.println();
//		
//		
//		CoinChangeCombination(10 , 2 , "");
//		System.out.println();
//		
//		
//		CoinChangePermutation(10 , "");
//		System.out.println();
//		
//		
//		QueenCombinationBoxRespective(box , 0 , 2 , 0 , "");
//		System.out.println();
//		
//		
		CoinChangeCoinRespect( new int[] {1,2,3,4,5,6} , 0 , 3 , "");
		System.out.println();
//		
//		
//		QueenCombination2D( new boolean[2][3] , 0 , 0 , 2 , 0 , "");
//		System.out.println();
//		
//		
//		QueenCombination2DKill(new int[4][4] , 0 , 0 , 4 , 0 , "");
//		System.out.println();
//		
//		
//		QueenCombination2DKill2(new boolean[4][4] , 0 , 0 , 3  , 0 , "");
//		System.out.println();
//		
//		
//		NKnights(new boolean [2][2] , 0 , 0 , 2 , 0 , "");
//		System.out.println();
//		
//		
//		int [][] maze= {{0,1,0,0} , {0,0,0,0} , {0,1,0,0} , {0,0,1,0}};
//		BlockedMaze(maze , 0 , 0 , "" , new boolean[maze.length][maze[0].length]);
//		System.out.println();
		
		
		
	}
	
	
	static void QueenCombinationAndPermutation(boolean[] box , int tq , int qpsf , String ans)
	{
		
		if(tq==qpsf)
		{
			System.out.println(ans);						
			return;
		}
		
		
		
		for(int j=i ; j<4 ; j++)
		{
//			box[j]=true;
//			qpsf++;
//			for(int i=0 ; i<4 ; i++)
//			{
//				if(box[i]==false)
//				{
//					box[i]=true;
//					printall(box , tq , qpsf+1 , ans+"q0b"+j+" q1b"+i);
//					ans="";
//					box[i]=false;
//				}
//			}
//			qpsf--;
//			box[j]=false;

			if(box[j]==false)
			{
				box[j]=true;
				QueenCombinationAndPermutation(box , tq , qpsf+1 , ans+ "q"+qpsf+"b"+j+" ");
				box[j]=false;
			}
			
			if(qpsf==0) i++;						// for combination , if you commend this , code will become for permutaion
			
			
		}
	
	}
	
	
	static void QueenPermutation(String[] box , int tq , int qpsf)
	{
		
		if(tq==qpsf)
		{
			for(int i=0 ; i<4 ; i++)
			{
				if(box[i]=="q0")
					System.out.print(box[i]+"b"+i+" ");
			}
			
			for(int i=0 ; i<4 ; i++)
			{
				if(box[i]=="q1")
					System.out.print(box[i]+"b"+i);
			}
			
			System.out.println();
			
			return;
		}
		
		
		
		for(int j=0 ; j<4 ; j++)
		{
			box[j]="q0";
			qpsf++;
			for(int i=0 ; i<4 ; i++)
			{
				if(box[i]==null)
				{
					box[i]="q1";
					QueenPermutation(box , tq , qpsf+1);
					box[i]=null;
				}
			}
			box[j]=null;
			qpsf--;
		}
		
		
		
	}
	
	
	static void CoinChangeCombination(int t , int kiske_Through_Aaya , String ans)
	{
		if(t==0) 
		{
			System.out.println(ans);
			return;
		}
		
		if(t<0) return;
		
		if(kiske_Through_Aaya<=2)
			CoinChangeCombination(t-2 , 2 , ans+"2");
		
		if(kiske_Through_Aaya<=3)
			CoinChangeCombination(t-3 , 3 , ans+"3");
		
		if(kiske_Through_Aaya<=5)
			CoinChangeCombination(t-5 , 5 , ans+"5");
		
		if(kiske_Through_Aaya<=6)
			CoinChangeCombination(t-6 , 6 , ans+"6");		
		
	}
	
	
	static void CoinChangePermutation(int t , String ans)
	{
		if(t==0) 
		{
			System.out.println(ans);
			return;
		}
		
		if(t<0) return;
		
		
			CoinChangePermutation(t-2 , ans+"2");
		
			CoinChangePermutation(t-3 , ans+"3");
		
			CoinChangePermutation(t-5 , ans+"5");
		
			CoinChangePermutation(t-6 , ans+"6");

		
		
	}

	
	static void QueenCombinationBoxRespective(boolean[] box , int i , int tq , int qpsf , String ans)
	{
		if(qpsf==tq)
		{
			System.out.println(ans);
			return;
		}
		
		if(i==box.length) return;
		
		box[i]=true;
		QueenCombinationBoxRespective(box , i+1 ,tq , qpsf+1 , ans+"b"+i);
		box[i]=false;
		
		QueenCombinationBoxRespective(box , i+1 ,tq , qpsf , ans);

		
	}

	
	static void CoinChangeCoinRespect(int a[] , int i , int t , String ans)
	{
		if(t==0) 
		{
			System.out.println(ans);
			return;
		}
		
		if(t<0 || i==a.length) return;
		
		CoinChangeCoinRespect(a , i , t-a[i] , ans+a[i]);
		
		CoinChangeCoinRespect(a , i+1 , t , ans);
		
	}

	
	static void QueenCombination2D(boolean [][]a , int i , int j , int tq , int qpsf , String ans)
	{	
	
		if(qpsf==tq)
		{
			System.out.println(ans);
			return;
		}
		
		if(i==a.length) return;
		
		if(j==a[0].length)
		{
			/* changing variables by calling extra recursive function */
			
//			QueenCombination2D(a , i+1 , 0 , tq , qpsf , ans);
//			return;
			
			/* OR */
			
			/* changing variables manually */
			i++;
			j=0;
		}
	
		a[i][j]=true;
		QueenCombination2D(a , i , j+1 , tq , qpsf+1 , ans+"{"+i+"-"+j+"}"+" ");
		a[i][j]=false;
		
		QueenCombination2D(a , i , j+1 , tq , qpsf , ans);
		
	}
	
	
	static void QueenCombination2DKill(int [][] chess , int row , int col , int tq , int qpsf , String ans)
	{
		if(tq==qpsf)
		{
			System.out.println(ans);
			return;
		}
		
		if(row==chess.length || col==chess[0].length) return;
		
		
		if(chess[row][col]==0)
		{
			changes(chess , row , col);
			QueenCombination2DKill(chess , row+1 , 0 , tq , qpsf+1 , ans+"{"+row+"-"+col+"} ");
			reverse(chess , row , col);
		}
		
		
		QueenCombination2DKill(chess , row , col+1 , tq , qpsf , ans);
		
		
	}
	private static void changes(int[][] chess, int row, int col) {
	
		for(int i=row ; i<chess.length ; i++)
		{
			if(chess[i][col]==0)
				chess[i][col]=row+1;
		}
		
		for(int i=col ; i<chess[0].length ; i++)
		{
			if(chess[row][i]==0)
				chess[row][i]=row+1;
		}
		
		int i=0;
		while(row+i<chess.length && col+i<chess[0].length)
		{
			if(chess[row+i][col+i]==0)
				chess[row+i][col+i]=row+1;
			
			i++;
		}
		
		i=0;
		while(row+i<chess.length && col-i>=0)
		{
			if(chess[row+i][col-i]==0)
				chess[row+i][col-i]=row+1;
			i++;
		}
		
	}
	private static void reverse(int[][] chess, int row, int col) {
	
		for(int i=row ; i<chess.length ; i++)
		{
			if(chess[i][col]==row+1)
				chess[i][col]=0;
		}
		
		for(int i=col ; i<chess[0].length ; i++)
		{
			if(chess[row][i]==row+1)
				chess[row][i]=0;
		}
		
		int i=0;
		while(row+i<chess.length && col+i<chess[0].length)
		{
			if(chess[row+i][col+i]==row+1)
				chess[row+i][col+i]=0;
		
			i++;
		}
		
		i=0;
		while(row+i<chess.length && col-i>=0)
		{
			if(chess[row+i][col-i]==row+1)
				chess[row+i][col-i]=0;
		
			i++;
		}		
	}

	
	static void QueenCombination2DKill2(boolean [][]a , int row , int col , int tq , int qpsf , String ans)
	{	
	
		if(qpsf==tq)
		{
			System.out.println(ans);
			return;
		}
				
		if(col==a[0].length)
		{
			row=row+1;
			col=0;
		}
		
		if(row==a.length) return;
	
		if( IsItSafeQueen(a , row , col) )
		{
			a[row][col]=true;
			QueenCombination2DKill2(a , row , col+1 , tq , qpsf+1 , ans+"{"+row+"-"+col+"}"+" ");
			a[row][col]=false;
		}
		
		QueenCombination2DKill2(a , row , col+1 , tq , qpsf , ans);
		
	}
	private static boolean IsItSafeQueen(boolean[][] a, int row, int col) {
		
		int i=0;
		
		// checking horizontally left
		while(i<col)
		{
			if(a[row][i]) return false;
			i++;
		}
		
		// checking vertically up
		i=1;
		while(row-i>=0)
		{
			if(a[row-i][col]) return false;
			i++;
		}

		// checking diagonally left upward
		i=1;
		while(row-i>=0 && col-i>=0)
		{
			if(a[row-i][col-i]) return false;
			i++;
		}
	
		// checking diagonally right up
		i=1;
		while(row-i>=0 && col+i<a[0].length)
		{
			if(a[row-i][col+i]) return false;
			i++;
		}
		
		return true;
	
	}

	
	static void NKnights(boolean[][] chess , int row , int col , int tk , int kpsf , String ans)
	{
		if(kpsf==tk )
		{
			System.out.println(ans);
			return;
		}
		
		if(row==chess.length) return;
		
		if(col==chess[0].length) 
		{
			NKnights(chess , row+1 , 0 , tk , kpsf , ans);
			return;
		}
		
		if(IsItSafeKnight(chess , row , col))
		{
			chess[row][col]=true;
			NKnights(chess , row , col+1 , tk , kpsf+1 , ans+"{"+row+"-"+col+"} ");
			chess[row][col]=false;
		}
		
		NKnights(chess , row , col+1 , tk , kpsf , ans);
		
	}
 	private static boolean IsItSafeKnight(boolean [][] chess , int row , int col)
	{
		if(row-2>=0 && col-1>=0)
			if(chess[row-2][col-1]) return false;
		
		if(row-2>=0 && col+1<chess[0].length)
			if(chess[row-2][col+1]) return false;
		
		if(row-1>=0 && col-2>=0)
			if(chess[row-1][col-2]) return false;
		
		if(row-1>=0 && col+2<chess[0].length)
			if(chess[row-1][col+2]) return false;
		
		return true;
	}
	

 	static void BlockedMaze(int [][] arr , int row , int col , String ans , boolean [][] visited) 
 	{
 		if(row==arr.length-1 && col==arr[0].length-1)
 		{
 			System.out.println(ans);
 			return;
 		}
 		
 		if(row==-1 || row==arr.length || col==-1 || col==arr[0].length)
 			return;
 		
 		if(arr[row][col]==1 || visited[row][col])
 			return;
 		
 		visited[row][col]=true; 
 		
 		BlockedMaze(arr , row , col-1 , ans+"L" , visited);
 		BlockedMaze(arr , row , col+1 , ans+"R" , visited);
 		BlockedMaze(arr , row-1 , col , ans+"T" , visited);
 		BlockedMaze(arr , row+1 , col , ans+"D" , visited);

 	    visited[row][col]=false;
 		
 	}

}










