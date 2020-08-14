package coding_Blocks.DP.Questions;

import java.util.Scanner;

public class MinimumJumpsReqd {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int i=1 ; i<=t ; i++)
		{
			// taking input
			int n=sc.nextInt();
			int [] arr=new int[n];
			for(int j=0 ; j<n ; j++)
				arr[j]=sc.nextInt();

			
			int max=0 , minCount=0 , position=0;;
			for(int j=0 ; j<n ; j++)
			{
				
				/*
				 * System.out.println("j->"+j);
				*/
				
				// checking that have we reached the end of array
				if(j+arr[j]>=arr.length-1)
				{
					minCount++;
					break;
				}
				
				// proceeding further
				for(int k=j+1 ; k <= j+arr[j] ; k++)
				{
					// checking which value will take you more far
					
					/*
					 * System.out.println("max->"+max+" , k+arr[k]->"+(k+arr[k])+" , k->"+k+" , arr[k]->"+arr[k]);
					*/
					
					if(max<k+arr[k] && arr[k]!=0)
					{
							max=k+arr[k];
							position=k;
					}
					
				}
				
				// checking if max has changed or not
				if(max==0)
				{
					System.out.println(Integer.MAX_VALUE);
					minCount=0;
					break;
				}
				
				// updating minCount and position of index i.e. (j)
				minCount++;
				j=position-1;
				max=0;
			}
			
			if(minCount!=0)
				System.out.println(minCount);	


		}
		
	}

	
}
