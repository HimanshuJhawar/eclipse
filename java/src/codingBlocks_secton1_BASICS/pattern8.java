package codingBlocks_secton1_BASICS;

public class pattern8 {

	public static void main(String[] args) {

		
		int n=11 , row=1;
		
		for(int i=1 ; i<=n ; i++)
		{
			if(row<n/2+1)
			{
				for(int j=1 ; j<=i-1 ; j++)
				{
					System.out.print(" ");
				}
				
				System.out.print("*");
				
				for(int j=n-2 ; j>=2*i-1 ; j--)
				{
					System.out.print(" ");
				}
				
				System.out.print("*");
			}
			
			
			if(row==n/2+1)
			{
				for(int j=1 ; j<=n/2 ; j++)
				{
					System.out.print(" ");
				}
				System.out.print("*");
			}
			
			
			if(row>n/2+1)
			{
				for(int j=n-i ; j>=1 ; j--)
				{
					System.out.print(" ");
				}
				
				System.out.print("*");
				
				for(int j=1 ; j<=2*(i-n/2-1)-1 ; j++)
				{
					System.out.print(" ");
				}
				
				System.out.print("*");
			}
			
			System.out.println();
			row++;
			
		}
		
	}
}
