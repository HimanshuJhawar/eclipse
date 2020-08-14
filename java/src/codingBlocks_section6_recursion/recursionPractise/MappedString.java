package codingBlocks_section6_recursion.recursionPractise;

import java.util.ArrayList;
import java.util.Scanner;

public class MappedString {
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		
		String s=""+a;

		ms(s , "");
				
	}
	
	
	static void ms(String s , String ans)
	{
		if(s.length()==0) 
		{
			System.out.println(ans);
			return;
		}
		
		
		ms(  s.substring(1) , ans + alphaS(s.charAt(0))  );
		
		if(  s.length()>=2  &&  (int)s.charAt(0)-'0'<3  )
		{	
			if((int)s.charAt(1)-'0'<7)
			ms(  s.substring(2) , ans + alphaD(s.substring(0,2))  );
		}
	}
	
	
	static char alphaS(char c)
	{
		if(c=='1') return 'A';
		if(c=='2') return 'B';
		if(c=='3') return 'C';
		if(c=='4') return 'D';
		if(c=='5') return 'E';
		if(c=='6') return 'F';
		if(c=='7') return 'G';
		if(c=='8') return 'H';
		if(c=='9') return 'I';

		return '@';

	}
	
	static String alphaD(String s)
	{
		if(s=="10") return "J";
		if(s=="11") return "K";
		if(s=="12") return "L";
		if(s=="13") return "M";
		if(s=="14") return "N";
		if(s=="15") return "O";
		if(s=="16") return "P";
		if(s=="17") return "Q";
		if(s=="18") return "R";
		if(s=="19") return "S";
		if(s=="20") return "T";
		if(s=="21") return "U";
		if(s=="22") return "V";
		if(s=="23") return "W";
		if(s=="24") return "X";
		if(s=="25") return "Y";
		if(s=="26") return "Z";

		
		return "no needed";	
		
	

	}

	
}