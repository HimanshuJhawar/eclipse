package coding_Blocks.DP.Questions;

import java.util.Scanner;

public class MaximumLengthBitonicSubarray {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();

		for(int i=1 ; i<=t ; i++)
		{
			int n=sc.nextInt();
			int arr[]=new int[n];
			for(int j=0 ; j<n ; j++)
				arr[j]=sc.nextInt();
			
			System.out.println(bitonic(arr));
		}
		
	}

	static int bitonic(int[] arr)
	{
//		entirely increasing	
		int length=1;
		for(int j=1 ; j<arr.length ; j++)
		{
			if(arr[j]>arr[j-1])
				length++;
			else
				break;
		}
		
		if(length==arr.length)
			return length;

		
//		entirely decreasing
		length=1;
		for(int j=1 ; j<arr.length ; j++)
		{
			if(arr[j]<arr[j-1])
			{
				length++;
			}
			else
				break;
		}
		
		if(length==arr.length)
			return length;
		
		
		
//		checking max length
		length=1;
		int max=0;
		int i=1;
		while(i<arr.length)
		{
			// when increasing			
			while(i<arr.length)
			{
				if(arr[i-1]<arr[i])
				{
					i++;
					length++;
				}
				else
				{
					break;
				}
			}
			
			// when decreasing
			while(i<arr.length)
			{
				if(arr[i-1]>arr[i])
				{
					i++;
					length++;
				}
				else
				{
					break;
				}
			}
			
			// upgrade max ans
			if(max<length)
				max=length;
			
			// checking again for new cycle
			length=1;
		}
		
		
		return max;
		
	}



	
	
}