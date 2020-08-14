package practise2;

import java.util.*;

class Practise {

	public static void main(String[] args) {

		int [] prime=new int[7];
		prime=getPrime(prime , 7);
		
		for(int i=0 ; i<prime.length ; i++)
		{
			System.out.println(prime[i]);
		}
		
		
	}
	
	
	static int[] getPrime(int [] prime , int Q)
	{
		prime[0]=2;
		int i=1;
			for(int k=3 ; k<=100000; k++)
			{
				boolean check=true;
				for(int j=2 ; j<k ; j++)
				{
					if(k%j==0)
					{
						check=false;
						break;
					}
				}
				
				if(check)
				{
					prime[i]=k;
					i++;
					if(i>=Q) break;
				}
			}			
		
		
		return prime;
	}

}



