package codingBlocks_section6_recursion.recursionPrintingCounting;

public class GetBoardPath {

	public static void main(String[] args) {

		int n=getBoardPathWays(0,10);
		System.out.println(n);
		
		
		getBoardPath(0,10,"");
		
	}

	
	static int getBoardPathWays(int start , int end)
	{
		if(start>end) return 0;
		
		if(start==end) return 1;
		
				
		int n=0;
		
		for(int dice=1 ; dice<=6 ; dice++) n+=getBoardPathWays(start+dice , end);

		return n;
	}

	static void getBoardPath(int start , int end , String ans)
	{
		if(start>end) return;
		
		if(start==end)
		{
			System.out.println(ans);
			return;
		}
		
				
		
		for(int dice=1 ; dice<=6 ; dice++) getBoardPath(start+dice , end , ans+dice);

	}
	
}
