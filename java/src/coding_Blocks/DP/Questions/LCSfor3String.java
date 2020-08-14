package coding_Blocks.DP.Questions;

import java.util.*;

public class LCSfor3String {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		String a=sc.nextLine();
		String b=sc.nextLine();
		String c = sc.nextLine();
		
		System.out.println(lcsI(a,b,c));

	}

	static int lcsI(String s1 , String s2 , String s3)
	{
		int [][][] storage=new int[s1.length()+1][s2.length()+1][s3.length()+1];
		storage[s1.length()][s2.length()][s3.length()]=0;
		
		for(int i=s1.length(); i>=0 ; i--)
		{
			for(int j=s2.length() ; j>=0 ; j--)
			{			
				for(int k=s3.length() ; k>=0 ; k--)
				{
					if(i==s1.length() || j==s2.length() || k==s3.length())
					{
						storage[i][j][k]=0;
						continue;
					}
					
					if(s1.charAt(i)==s2.charAt(j) && s1.charAt(i)==s3.charAt(k))
						storage[i][j][k]=1+storage[i+1][j+1][k+1];
					else
						storage[i][j][k]=Math.max( storage[i+1][j][k] , Math.max(storage[i][j+1][k] , storage[i][j][k+1] ) ); 	
				}
			}
		}
	
		return storage[0][0][0];
	}

	
}
