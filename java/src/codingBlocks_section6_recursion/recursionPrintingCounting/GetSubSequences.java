package codingBlocks_section6_recursion.recursionPrintingCounting;

public class GetSubSequences {

	public static void main(String[] args) {

		getSubSequencesAscii("ab" , "");
		
	}

	
	static void getSubSequencesAscii(String s , String r)
	{
		if(s.length()==0)
		{
			System.out.println(r);
			return;
		}
		
		
		char cc=s.charAt(0);
		String sbs=s.substring(1);
		
		
		getSubSequencesAscii(sbs,r);								// doesn't include current character in result
		
		getSubSequencesAscii(sbs,""+r+(int)cc);				    	// include ASCII value of current character
		
		getSubSequencesAscii(sbs,r+cc);						    	// include current character in result
		
		
	}
	
	
}
