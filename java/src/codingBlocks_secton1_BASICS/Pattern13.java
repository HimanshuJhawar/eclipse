package codingBlocks_secton1_BASICS;

public class Pattern13 {

	public static void main(String[] args) {

		int n=9;
		for(int i=1 ; i<=n ; i++)
		{
			for(int j=2*(n-i)-1 ; j>=0 ; j--)
			{
				System.out.print(" ");
			}
			
			for(int j=0 ; j<i-1 ; j++)
			{
				System.out.print("* ! ");
			}
			
			System.out.print("*");
			
			System.out.println();
		}
	}

}
