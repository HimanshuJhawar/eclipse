package codingBlocks_section6_recursion.recursionPrintingCounting;

public class GetPermutation {

	public static void main(String[] args) {

			getPermutation("abc","");
		
		
	}
	
	
	static void getPermutation(String ques , String ans)
	{
		
		if(ques.length()==0)
		{
			System.out.println(ans);
			return;
		}
		

		for(int i=0 ; i<ques.length() ; i++)
		{
			
			getPermutation( ques.substring(0,i) + ques.substring(i+1) , ans + ques.charAt(i));
			
			
			
		}
		
		
		
	}
	

}
