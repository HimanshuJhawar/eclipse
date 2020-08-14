package coding_Blocks.DP.Questions;

import java.util.*;

public class ExchangingCoin {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		System.out.println(exchange(n , new int[n+1]));
		System.out.println( exchange( n , new HashMap<Integer , Long>() ) );
	}

//	this can be used when n is small , if n is large , array will take large amount of space and that will give TLE
	static int exchange(int n , int[] arr)
	{
		if(n==0) return 0;
		if(n==1) return 1;
		
		if(arr[n]!=0) return arr[n];
		
		int max = exchange(n/2 , arr) + exchange(n/3 , arr) + exchange(n/4 , arr);
	
		max=Math.max(max, n);

		arr[n]=max;
		return max;
		

		
		
		
		
		
		
		
//		int[] storage = new int[n+1];
//		storage[1]=1;
//		
//		for(int j=2 ; j<=n ; j++)
//		{
//			storage[j] = Math.max( j , storage[j/2] + storage[j/3] + storage[j/4] );
//		}
//		
//		return storage[n];
		
	}

	
//  HashMap is used for large n , because arrray cant ne made of very big n like n=10000000000	
	static long exchange(int n , Map<Integer , Long> storage)
	{
		
		if(n==0) return 0;
		if(n==1) return 1;
		
		if(storage.containsKey(n)) return storage.get(n);
		
		long max = exchange(n/2 , storage) + exchange(n/3 , storage) + exchange(n/4 , storage);
		
		max=Math.max(n , max);
		
		storage.put(n , max);
		
		return max;
		
	}
	
}
