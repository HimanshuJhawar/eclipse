package codingBlocks_secton1_BASICS;

public class Pattern31 {

	public static void main(String[] args) {

		int n=5;
		for(int i=1 ; i<=n ; i++)
		{
			int val=5;
			for(int j=1 ; j<=n; j++)
			{
				if(j!=n-i+1)System.out.print(val);
				if(j==n-i+1)System.out.print("*");
				val--;
			}
			System.out.println();
		}
		
	}

}
