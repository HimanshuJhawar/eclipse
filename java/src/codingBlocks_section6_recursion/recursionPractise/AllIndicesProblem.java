package codingBlocks_section6_recursion.recursionPractise;

import java.util.*;

public class AllIndicesProblem {

	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int [] arr=new int[N];
		for(int i=0 ; i<N ; i++)
		{
			arr[i]=sc.nextInt();
		}
		int M=sc.nextInt();
		
		
		int i=0;
		ArrayList<Integer> ans=aip(arr , i , M , 0);
		
		
		int [] result=new int[ans.size()];
		for(int j=0 ; j<ans.size(); j++)
		{
			result[j]=ans.get(j);
		}
		for(int j=0 ; j<result.length ; j++)
		{
		System.out.print(result[j]+" ");
		}
	}

	
	static ArrayList<Integer> aip(int [] arr , int i , int M , int count)
	{
		ArrayList<Integer> recans=new ArrayList<>();
		ArrayList<Integer> myans=new ArrayList<>();

		
		if(i==arr.length) return recans;
		
		if(arr[i]==M)
		{
			myans.add(i);
		}
		
		recans=aip(arr,i+1,M,count);
		
		for(int j=0 ; j<recans.size(); j++)
		{
			myans.add(recans.get(j));
		}
		
		return myans;
		
	}
	
	
}
