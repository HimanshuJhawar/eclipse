package codingBlocks_secton1_BASICS;

public class Pattern27 {

	public static void main(String[] args) {

		int n=6 ;
		int val=-1;
		for(int i=1 ; i<=n ; i++)
		{
			val+=2;
			for(int j=1 ; j<=n-i ; j++)
			{
				System.out.print(" ");
			}
			
			for(int j=1 ; j<=2*i-1 ; j++)
			{
				System.out.print(val);
		        if(j<i)val++;
		        if(j>=i)val--;  
			}
			System.out.println();
		}
		
		
	}

}
