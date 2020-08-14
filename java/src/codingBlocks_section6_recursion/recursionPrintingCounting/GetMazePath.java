package codingBlocks_section6_recursion.recursionPrintingCounting;

public class GetMazePath {

	public static void main(String[] args) {

		
		getMazePath(0,0,2,2,"");
		
		
		int n=countMazePath(0,0,2,2);
		System.out.println(n);
		
	}
	
	
	static void getMazePath(int sH , int sV , int eH , int eV , String ans)
	{
		
		if(sH>eH||sV>eV) return;
		
		if(sH==eH&&sV==eV)
		{
			System.out.println(ans);
			return;
		}
		
		getMazePath(sH+1 , sV , eH , eV , ans+"H");
		
		getMazePath(sH , sV+1 , eH , eV , ans+"V");
		
	}
	
	
	static int countMazePath(int sH , int sV , int eH , int eV)
	{
		
		if(sH>eH&&sV>eV) return 0;
		
		if(sH==eH || sV==eV) return 1;
		
		
		int a=countMazePath(sH+1 , sV , eH , eV);

//		n=0;
		
		int b=countMazePath(sH , sV+1 , eH , eV);
		
		return a+b;
		
	}


}
