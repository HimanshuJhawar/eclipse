package coding_Blocks.HashMap.Questions;

import java.util.*;

public class SubArrayWithDistinctElements {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[] = new int[n];
		for(int i=0 ; i<n ; i++)
			a[i]=sc.nextInt();
		
		
		int sum=0,avail=0,breaker=0;
		HashMap<Integer , Integer> m = new HashMap<>();
		for(int i=0 ; i<n ; i++) {
			
			if(m.get(a[i])!=null && m.get(a[i])>breaker) {
							
				breaker=i;
				
				int index=m.get(a[i]);
				sum=sum+sum(avail) - sum(i-(index+1)) ;
				avail=i-index;
				
				m.put(a[i] , i);
				
			} else {
				m.put(a[i] , i);
				avail++;
			}
			
		}
		
		
		sum = sum+sum(avail);
		
		System.out.println(sum);
//		System.out.println(sumoflength(a , n));
	} 
	
	public static int sum(int avail) {
		return  (avail+2)*avail*(avail+1) / 6 ;
	}

	
    public static int sumoflength(int[] arr, int n)  
	    { 
	  
	        // For maintaining distinct elements. 
	        Set<Integer> s = new HashSet<>(); 
	  
	        // Initialize ending point and result 
	        int j = 0, ans = 0; 
	  
	        // Fix starting point 
	        for (int i = 0; i < n; i++) 
	        { 
	            while (j < n && !s.contains(arr[j])) 
	            { 
	                s.add(arr[i]); 
	                j++; 
	            } 
	  
	            // Calculating and adding all possible length 
	            // subarrays in arr[i..j] 
	            ans += ((j - i) * (j - i + 1)) / 2; 
	  
	            // Remove arr[i] as we pick new stating point 
	            // from next 
	            s.remove(arr[i]); 
	        } 
	  
	        return ans; 
	    } 




}
