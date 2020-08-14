package coding_Blocks.HashMap.Questions;

import java.util.*;

public class Unlock {

	public static void main(String[] args) {

			
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		int a[]=new int[n];
		HashMap<Integer , Integer> map=new HashMap<>();
		for(int i=0 ; i<n ; i++)
		{
			int x=sc.nextInt();
			map.put(x , i);
			a[i]=x;
		}
		
		int smaller = k>n ? n:k ;
		for(int i=0 ; i<smaller ; i++)
		{
			if(i==n) break;
			
			int index=map.get(n-i);
			
			if(index!=i)
			{
				map.put(a[i] , index);
				map.put(a[index] , i);
				
				int swap = a[i];
				a[i]=a[index];
				a[index]=swap;
			}
			else if(index==i)
			{
				smaller++;
			}
		}
		
		for(int i=0 ; i<n ; i++)
		{
			System.out.print(a[i]+" ");
		}
		
	}

}
