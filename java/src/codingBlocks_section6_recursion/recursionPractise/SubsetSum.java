package codingBlocks_section6_recursion.recursionPractise;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsetSum {

	static ArrayList<Integer> ans=new ArrayList<>();						// introducing two arraylist outside main so that
	static ArrayList<Integer> storing_elements=new ArrayList<>();			// we dont have to send them again in recursion
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int j=1 ; j<=T ; j++)
		{
			
			int N=sc.nextInt();
			int [] arr=new int[N];								
			int sum=0;
			for(int i=0 ; i<N ; i++)
			{
				arr[i]=sc.nextInt();							// taking elements in array
				storing_elements.add(arr[i]);					// converting array into array list
			}
			
			findsubsequences(0 , 0 );     						// calling function
			
			String check="No";
			for(int i=0 ; i<ans.size()-1 ; i++)
			{
				if(ans.get(i)==0)
					check="Yes";
					
			}
	
			ans.clear();										// making this array so that in next round
			storing_elements.clear();							// they should act as new array list
			
			System.out.println(check);							// printing result


		}
        
    } 
  
    private static void findsubsequences( int sum , int i )			      // i=iterating in arraylist
    { 																	 
        if(i==storing_elements.size()) 									  // sum is used to store all sub sums and then finally add in arraylist	
        { 
            ans.add(sum);  
            return; 
        } 
  
        int extra=storing_elements.get(i);								 // extra = similar to the role of char cc in finding all subsequences of string
     
        findsubsequences( extra + sum , i+1) ;		 					 // extra+sum == extra + sum of all subsequenc of arraylist from i'th position
  
              
        findsubsequences( sum , i+1); 									 // sum == indicates that sum of all subsequenc of arraylist from i'th position
		
	}

}
