package CB_Section9_BackTracking.questions;

import java.util.Scanner;

public class ClassAssignment {

	static int resul=0;

	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=1 ; i<=T ; i++)
		{
			int n=sc.nextInt();
			
			ca(n , "a");
			ca(n , "b");
			System.out.println(  "#" + i + " : " + resul  );
			resul=0;
		}
	 
		
	 } 

	
	static void ca(int n , String ans)
	{
		if(n==0) return;
		
		if(ans.length()>=n) 
		{
			resul=resul+1;
			return;
		}
		
		
		if(ans.charAt(ans.length()-1)=='a')
		{
			ca(n , ans+"a");
			ca(n , ans+"b");
		}
		
		if(ans.charAt(ans.length()-1)=='b')
		{
			ca(n , ans+"a");
		}
		
		
		
	}

}
