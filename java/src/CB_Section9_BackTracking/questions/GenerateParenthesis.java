package CB_Section9_BackTracking.questions;

import java.util.*;

public class GenerateParenthesis {

	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		
		gp(0 , n , "");
		
		
		
	}
	
	
	static void gp(int checkClose , int checkOpen , String ans)
	{
		if(checkOpen==0 && checkClose==0)
		{
			System.out.println(ans);
			return;
		}
		
		
		if(checkClose>0)
			gp(checkClose-1 , checkOpen , ans+")");
		
		
		if(checkOpen>0)
			gp(checkClose+1 , checkOpen-1 , ans+"(");
		
		
		
	}
	

}
