package coding_Blocks.HashMap.Questions;

import java.util.Scanner;

public class MaxXORSubArray {


     public static void main(String[] args) {
	    	
	    	// my code , works in O(N^2) time
			myans();


			
			// Answer given in editorial , works in O(N) time
			
			/*
			 * This problem can be solved in O(n) time complexity by using Trie.
			 *  We will store the prefix xor of every element of the given array.
			 *  (For a particular index j the prefix xor of array[j] will be array[0]^array[1]......^array[j])
			 *  As we are storing the prefix xor then every node of the trie 
			 *  will either contain 0 or 1.Let's say F(L,R) is XOR of subarray from L to R. 
			 *  Here we use the property that F(L,R)=F(1,R) XOR F(1,L-1). How? Let's say our
			 *  subarray with maximum XOR ended at position i. Now, we need to maximise 
			 *  F(L,i) ie. F(1,i) XOR F(1,L-1) where L<=i. To find the prefix F(1, L-1) we 
			 *  find the entry in Trie that has maximum XOR value with current prefix. If we do XOR 
			 *  of such previous prefix with current prefix, we get the maximum XOR value ending with arr[i].
	        */
	        Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();
	        int[] arr = new int[n];
	        for (int i = 0; i < arr.length; i++) { // Take input of the array
	            arr[i] = scn.nextInt();
	        }
	        int pre_xor = 0;
	        int result = Integer.MIN_VALUE;
	        trieNode head = new trieNode();
	        for (int i = 0; i < arr.length; i++) {
	            pre_xor ^= arr[i]; // Calculate the prefix xor upto indedx i
	            insert(pre_xor, head); // Insert the prefix xor in the trie
	            result = Math.max(result, query(head, pre_xor, n)); // Query for the maximum xor subarray
	        }
	        System.out.println(result);
	    }

     public static void myans() {	
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int a[] = new int[n];
		for(int i=0 ; i<n ; i++)
			a[i]=sc.nextInt();
		
		int sub=0,max=0;
		for(int i=0 ; i<n ; i++)
		{
			for(int j=i ; j<n ; j++)
			{
				sub=sub^a[j];
				
				if(max<sub)
					max=sub;
			}
			sub=0;
		}
		
		System.out.println(max);
	}
	
	 public static class trieNode {
	        trieNode left;
	        trieNode right;
	        int value;
	    }
  
	 public static void insert(int n, trieNode head) {
	        trieNode curr = head;
	        for (int i = 31; i >= 0; i--) {
	            int bit = (n >> i) & 1;
	            if (bit == 0) {
	                if (curr.left == null) {
	                    curr.left = new trieNode();
	                }
	                curr = curr.left;
	            } else {
	                if (curr.right == null) {
	                    curr.right = new trieNode();
	                }
	                curr = curr.right;
	            }
	        }
	        curr.value = n;
	    }

     public static int query(trieNode head, int value, int n) {
	        int max_xor = Integer.MIN_VALUE;
	        trieNode curr = head;
	        int curr_xor = 0;
	        for (int j = 31; j >= 0; j--) {
	            int b = (value >> j) & 1;
	            if (b == 0) {
	                if (curr.right != null) {
	                    curr = curr.right;
	                } else {
	                    curr = curr.left;
	                }
	            } else {
	                if (curr.left != null) {
	                    curr = curr.left;
	                } else {
	                    curr = curr.right;
	                }
	            }
	        }
	        return value^curr.value;
	    }


}
