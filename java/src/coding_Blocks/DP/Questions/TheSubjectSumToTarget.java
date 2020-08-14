package coding_Blocks.DP.Questions;

import java.util.Scanner;

public class TheSubjectSumToTarget {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int sum=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0 ; i<n ; i++)
			arr[i]=sc.nextInt();
		
		System.out.println(SubjectSum(arr , 0 , sum , new String[n+1]));
	}

	static String SubjectSum(int[] arr , int i , int sum , String[] storage)
	{
		if(sum==0) 	return"Yes";
		if(i>=arr.length || sum<0)  return "No";
		
		String ans="";
		
		if(storage[i+1]!=null) return storage[i+1];

		for(int j=i ; j<arr.length ; j++)
		{
			ans=SubjectSum(arr , j+1 , sum-arr[j] , storage);
			
			if(ans=="Yes")
				break;
		}
		
		storage[i+1]=ans;
		return ans;
	}
	
}
