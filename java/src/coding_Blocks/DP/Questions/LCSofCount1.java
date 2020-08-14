package coding_Blocks.DP.Questions;

import java.util.*;

public class LCSofCount1 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int []arr = new int[n];
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0 ; i<n ; i++)
		{
			arr[i]=sc.nextInt();
			if(arr[i]==0)
				al.add(i);
		}
		
		int max=0,l=0,m=0 , ll=0 , mm=0;
		for(int i=0 ; i<al.size()-k ; i++)
		{
			int check=0;
			
			if(i==0){
				l = 0 ;
				m = al.get(k+i) - 1 ;
				
				check = (m+1) - l ;
			} else {
				m = al.get(k+i)-1 ;
				l = al.get(i-1)+1 ;
				
				check = m - l + 1 ;
			}
				
			if(max<check) {
				ll=l;
				mm=m;					
				
				max=check;
			}
		}
		
			
		for(int i=ll ; i<mm ; i++)
			arr[i]=1;
		System.out.println(max);
		for(int i=0 ; i<arr.length ; i++)
			System.out.print(arr[i]+" ");
	
		
		
	}
	

}
