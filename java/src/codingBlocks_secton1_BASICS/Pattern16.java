package codingBlocks_secton1_BASICS;

public class Pattern16 {

	public static void main(String[] args) {
		
		int n=9,row=1;
		for(int i=1 ; i<=n ; i++)
		{
			if(row<=n/2)
			{
				for(int j=n/2-i+1 ; j>=1 ; j--)
				{
					System.out.print("* ");
				}
				
				for(int j=1 ; j<=i ; j++)
				{
					System.out.print("    ");
				}
				
				for(int j=n/2-i+1 ; j>=1 ; j--)
				{
					System.out.print("* ");
				}
			}
			
			if(row>n/2+1)
			{
				for(int j=1 ; j<=i-n/2-1 ; j++)
				{
					System.out.print("* ");
				}
				
				for(int j=2*(n/2)-i+2 ; j>=1 ; j--)
				{
					System.out.print("    ");
				}
				
				for(int j=1 ; j<=i-n/2-1 ; j++)
				{
					System.out.print("* ");
				}
			}
			
			System.out.println();
			row++;
		}
		
	}

}
