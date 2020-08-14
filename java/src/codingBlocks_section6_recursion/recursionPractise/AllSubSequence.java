package codingBlocks_section6_recursion.recursionPractise;

import java.util.*;


public class AllSubSequence {

	static ArrayList<String> al = new ArrayList<>();
	
	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		String space=sc.nextLine();
		for(int j=1 ; j<=N ; j++)
		{
			String s=sc.nextLine();
			subseq(s , "");
			Collections.sort(al) ; 
			for(int i=0 ; i<al.size() ; i++)
				System.out.println(al.get(i));
			
			al.clear();
		}
	}

	static void subseq(String s , String ans)
	{
		if(s.length()==0)	
		{
			if(!al.contains(ans))
			al.add(ans);
			return;
		}
		
		
		String sb=s.substring(1);
		char c=s.charAt(0);
		

		subseq(sb , ans+c);
		
		subseq(sb , ans);
	}
	
}
