package codingBlocks_secton1_BASICS;

public class Pattern24 {

	public static void main(String[] args) {

		int n=6 ;
		for(int i=1 ; i<=n ; i++)
		{
			for(int j=1 ; j<=n-i ; j++)
			{
				System.out.print(" ");
			}
			int val=1;
			for(int j=1 ; j<=2*i-1 ; j++)
			{
				System.out.print(val);
		        val++;
			}
			System.out.println();
		}
		
	}

}
