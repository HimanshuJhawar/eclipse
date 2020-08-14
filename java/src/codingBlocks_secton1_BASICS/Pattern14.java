package codingBlocks_secton1_BASICS;

public class Pattern14 {

	public static void main(String[] args) {

		int n=9,a=1,row=1;
		for(int i=1 ; i<=n ; i++)
		{
			if(row<=n/2+1)
			{
			for(int j=1 ; j<=(n/2-i+1) ; j++)
				System.out.print("  ");
			
			for(int j=1 ; j<=i ; j++)
				System.out.print("* ");
			}
			
			if(row>n/2+1)
			{
			for(int j=1 ; j<=a ; j++)
				System.out.print("  ");
			
			for(int j=1 ; j<=n-i+1 ; j++)
				System.out.print("* ");
			
			a++;
			}
			
			System.out.println();
			row++;
		}
		
	}

}
