package codiingBlocks_Sorting;

import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] arr = new int[N];
		for(int i=0 ; i<N ; i++)
		{
			arr[i]=sc.nextInt();
		}
		
		int [] sorted=mergeSort(arr,0,arr.length-1);
		
		for(int i=0 ; i<sorted.length ; i++)
		{
			System.out.print(sorted[i]+" ");
		}
		
	}
	
	
	static int [] mergeSort(int [] arr , int start , int end)
	{
		if(start==end)
		{
			int [] baseCase=new int[1];
			baseCase[0]=arr[start];
			return baseCase;
		}
		
		int mid=(start+end)/2;
		
		int [] firstHalf=mergeSort(arr,start,mid);
		
		int [] secondHalf=mergeSort(arr,mid+1,end);
		
		int [] combineSorted=combine(firstHalf , secondHalf);
		
		return combineSorted;
		
	}
	
	static int[] combine(int [] one , int [] two)
	{
		
		int [] returning=new int[one.length + two.length];
		
		int i=0,j=0,k=0;
		while(one.length>j && two.length >k)
		{
			if(one[j]<two[k])
			{
				returning[i]=one[j];
				i++;
				j++;
			}
			else
			{
				returning[i]=two[k];
				i++;
				k++;
			}
			
		}
		
		if(j==one.length)
		{
			while(k<two.length)
			{
				returning[i]=two[k];
				k++;
				i++;
			}
		}
		
		if(k==two.length)
		{
			while(j<one.length)
			{
				returning[i]=one[j];
				j++;
				i++;
			}
		}
		
		return returning;
		
		
		
	}

}
