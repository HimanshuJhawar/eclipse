package codingBlocks_secton1_BASICS;

public class Pattern29 {

	public static void main(String[] args) {

		int n=5 ;
		int val=0,zero=0;
		for(int i=1 ; i<=n ; i++)
		{
			val++;
			for(int j=1 ; j<=n-i ; j++)
			{
				System.out.print(" ");
			}
			
				System.out.print(val);
			
			if(i>=2)
			{
				for(int j=1 ; j<= 2*i-1-2; j++)
				{
					System.out.print(zero);
				}
			}
				
		    if(i>=2)System.out.print(val);
				
			System.out.println();
		}

		
	}

}
