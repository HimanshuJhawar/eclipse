package CB_Section9_BackTracking.questions;

import java.util.*;

public class SumItUp {

	static ArrayList<String> res=new ArrayList<>();
	
	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] arr=new int[N];
		for(int i=0 ; i<arr.length ; i++)
			arr[i]=sc.nextInt();
		
		int t=sc.nextInt();
		
		Arrays.sort(arr);
		
		siu(arr , t , "" , 0);
		
		for(String i:res/*=0 ; i<res.size(); i++*/)
		System.out.println(i);
		
		
	}
	
	static void siu(int [] arr , int t , String ans , int i)
	{
	//	System.out.println(t);
		
		if(t==0)
		{
			if(!res.contains(ans))
			res.add(ans);
			return;
		}
		
		if(t<0||i>=arr.length)
			return;
		
		
		siu(arr , t-arr[i] , ans+arr[i]+" " , i+1);
		
		siu(arr , t , ans , i+1);
		
		
	}

}
