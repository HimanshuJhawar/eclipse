package coding_Blocks.DP;

public class DP {

	static long start;
	static long end;
	
	public static void main(String[] args) {

//		startAlgo();
//		int n=10 ;
//		System.out.println(countBoardPath(n , "" , new int [n+1]));
//		System.out.println(countBoardPath(n));
//		endAlgo();
//		
//		String s1="abbg" , s2="agbg";
//		System.out.println(lcs(s1, s2));
//		
//		
//		String change1="himan" , change2="hi";
//		System.out.println(changeString(change1+" " , change2+" " , 0));
//		System.out.println( changeString( change1 , change2 , new int[change1.length()+1][change2.length()+1] ) );
//		
//		int n=92;
//		startAlgo();
//		System.out.println(CountNumberOfBinaryString(n , 0));
//		endAlgo();
//		startAlgo();
//		System.out.println(CountNumberOfBinaryString(n));
//		endAlgo();
//		
//		
//		int [] arr = {};
//		System.out.println(LongestIncreasingSubsequence(arr));
		
		
	}
	
	
	
	static void startAlgo()
	{
		start=System.currentTimeMillis();
	}
	static void endAlgo()
	{
		end=System.currentTimeMillis() - start;
		System.out.println(end+"milliSec");
	}
	
	
	
//  DP with recursion	
	static int countBoardPath(int n , String ans , int[] storage)
	{
		if(n<0) return 0;
		if(n==0) return 1;
		
		
		if(storage[n]!=0) return storage[n];
		
		
		int count = 0;
		for(int i=1 ; i<=6 ; i++)
			count+=countBoardPath(n-i , ans+i , storage);
		
		
//	    this is condition of DP
		storage[n]=count;

		
		return count;
	}
//  DP with iteration
	static int countBoardPath(int n)
	{
		int storage[]=new int[n+1];
		
//		storage[0] means , 0 tak jaane ke kitne ways honge , ab ham start bhi 0 se kar rahe hai and end bhi agar 0 par hi karenge
//		toh 1 hi way hoga naa , bcoz kisi bhi number se ussi number tak jaane ka toh 1 hi way hai ki 
//		{ number select hi naa karo }		
		storage[0]=1;		
		
		/*  storage[3] = storage[2] + storage[1] + storage[0] */
		
		int i=1;
		while(i<=n)
		{
			for(int j=1 ; j<=6 ; j++)
			{
				if(i-j>=0)									/* example , storage[8] = storage[7] + storage[6] + storage[5]   */
					storage[i]+=storage[i-j];				/*						  storage[4] + storage[3] + storage[2]	 */
			}
//			System.out.println(i+"->"+storage[i]);
			i++;
		}
		
		return storage[n];
		
	}
	

	
//  T.C. = 2^(s1.length+s2.length)
//  Recursive Approach	
	static int lcs(String a , String b )
	{
				
		if(a.length()==0 || b.length()==0) return 0;
		
		int count=0,try1=0,try2=0;
		
		
		
		
		if(a.charAt(0)==b.charAt(0))
		{
			count = 1 + lcs(a.substring(1) , b.substring(1) );
		}
		else
		{
			try1 = lcs(a.substring(1) , b);
			try2 = lcs(a , b.substring(1));
			count = Math.max(try1, try2);
		}
		
		return count;

	
	}
//  T.C. =  s1.length+s2.length	
//	Loop Approach
	static int lcsI(String s1 , String s2)
	{
		int [][] storage=new int[s1.length()+1][s2.length()+1];
		storage[s1.length()][s2.length()]=0;
		
		for(int i=s1.length(); i>=0 ; i--)
		{
			for(int j=s2.length() ; j>=0 ; j--)
			{
				
				if(i==s1.length() || j==s2.length())
				{
					storage[i][j]=0;
					continue;
				}
				
				if(s1.charAt(i)==s2.charAt(j))
					storage[i][j]=1+storage[i+1][j+1];
				else
					storage[i][j]=Math.max(storage[i+1][j] , storage[i][j+1]); 
				
			}
		}
	
		return storage[0][0];
	}

	
	
//	T.C. = 2^(s1.length+s2.length)
//  Recursive Approach	
	static int changeString(String s1 , String s2 , int count)
	{
		if(s1.length()==1)		return s2.length()-1;
		if(s2.length()==1)		return s1.length()-1;
		
		
		char a=s1.charAt(0);
		char b=s2.charAt(0);
		
		
		if(a==b)
			count = changeString(s1.substring(1) , s2.substring(1) , count);
		else
		{
			int try1 = changeString(s1.substring(1) , s2 , count);
			int try2 = changeString(s1 , s2.substring(1) , count);
			int try3 = changeString(s1.substring(1) , s2.substring(1) , count);
			
			count = Math.max(try1 , Math.max(try2 , try3));
		}
		
		
		return count;
		
	}
//  T.C. = (s1.length+1)*(s2.length+!)
//	Loop Approach
	static int changeString(String s1 , String s2 , int[][] arr)
	{
		
		arr[s1.length()][s2.length()]=0;
		
		for(int i=s1.length() ; i>=0 ; i--)
		{
			for(int j=s2.length() ; j>=0 ; j--)
			{
				if(i==s1.length())
				{
					arr[i][j]=s2.length()-j;
					continue;
				}
				if(j==s2.length())
				{
					arr[i][j]=s1.length()-i;
					continue;
				}
				
				if(s1.charAt(i)==s2.charAt(j))
				{
					arr[i][j] = arr[i+1][j+1];
				}
				else
				{	
					arr[i][j] = 1 + Math.min(arr[i][j+1] , Math.min(arr[i+1][j] , arr[i+1][j+1]));
				}
				
			}
		}
		
		
		return arr[0][0];
		
	}
	
	
	
//	T.C. = 2^n
//  Recursive Approach	
	static long CountNumberOfBinaryString(int n , int last_digit)
	{
		if(n==0) return 1;
		
		long count=0;
		
		count += CountNumberOfBinaryString(n-1 , 0);
		
		if(last_digit!=1)
		count += CountNumberOfBinaryString(n-1 , 1);

		
		return count;
	}
//  T.C. = O(N)
//	Loop Approach
	static long CountNumberOfBinaryString(int n)
	{
		long[] zero = new long[n];
		long[] one = new long[n];
		
		
		zero[0]=one[0]=1;
		
		for(int i= 1; i<n ; i++)
		{
			zero[i] = zero[i-1] + one[i-1];
			one[i] = zero[i-1];
		}
		
		return zero[n-1]+one[n-1];
	}

	
	
//  T.C. = O(N*2)	
	static int LongestIncreasingSubsequence(int [] arr)
	{
		if(arr.length==0)
			return 0;
		
		int result[] = new int[arr.length];
		
		for(int i=1 ; i<arr.length ; i++)
		{
			result[i]=1;
			for(int j=0 ; j<i ; j++)
			{
				if(arr[i]>arr[j])
				{
					if(result[j]+1>result[i])
						result[i]=result[j]+1;
				}
			}
		}
		
		
		int max=0;
		for(int i=0 ; i<arr.length ; i++)
		{
			if(arr[i]>max)
				max=arr[i];
		}
		
		return max;
	
	}
	
}























