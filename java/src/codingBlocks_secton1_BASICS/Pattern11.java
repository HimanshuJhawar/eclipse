package codingBlocks_secton1_BASICS;

public class Pattern11 {

	public static void main(String[] args) {

		
		int n=7;
		for(int i=1 ; i<=n ; i++)
		{
			for(int j=n-i ; j>=1 ; j--)
			{
				System.out.print(" ");
			}
			
			for(int j=1 ; j<=i ; j++)
			{
				System.out.print("* ");
			}
			
			System.out.println();
		}
		
	}

}
