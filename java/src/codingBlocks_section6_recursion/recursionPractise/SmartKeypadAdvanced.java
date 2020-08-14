package codingBlocks_section6_recursion.recursionPractise;

import java.util.ArrayList;
import java.util.Scanner;

public class SmartKeypadAdvanced {
	
	static ArrayList<String> ans=new ArrayList<>();


	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		ans.add("");
		String s=""+a;
		keypadCodes(s);
		
		String searchIn[]= {
	            "prateek", "sneha", "deepak", "arnav", "shikha", "palak",
	            "utkarsh", "divyam", "vidhi", "sparsh", "akku"
	    };
		
//		System.out.println(ans);
		
//		if(ans.get(0).equals("dg"))
//			System.out.println(ans);
		
		for(int i=0 ; i<ans.size(); i++)
		{
			for(int j=0 ; j<searchIn.length ; j++)
			{
				for(int k=0 ; k <= searchIn[j].length() - ans.get(i).length() ; k++)
				{
					
					if( ans.get(i).equals ( searchIn[j].substring( k , k + ans.get(i).length() ) ) )
					{
						System.out.println(searchIn[j]);
					}
					
				}
			}
		}
		
		
	}
	
	static void keypadCodes(String s )
	{
		if(s.length()==0) return;
		
		char c=s.charAt(0);
		String sb=s.substring(1);
		
		character(c);
		
		keypadCodes(sb);
		
	}
	
	
	static void character(char ch )
	{
		int l=ans.size();
		
		if(ch=='2')
		{
			for(int i=0 ; i<l ; i++)
			{
				ans.add(ans.get(i)+"a");
				ans.add(ans.get(i)+"b");
				ans.add(ans.get(i)+"c");
			}
			
			for(int i=0 ; i<l ; i++)
			{
				ans.remove(0);
			}
		}
		
		if(ch=='3')
		{
			for(int i=0 ; i<l ; i++)
			{
				ans.add(ans.get(i)+"d");
				ans.add(ans.get(i)+"e");
				ans.add(ans.get(i)+"f");
			}
			
			for(int i=0 ; i<l ; i++)
			{
				ans.remove(0);
			}
		}
		
		if(ch=='4')
		{
			for(int i=0 ; i<l ; i++)
			{
				ans.add(ans.get(i)+"g");
				ans.add(ans.get(i)+"h");
				ans.add(ans.get(i)+"i");
			}
			
			for(int i=0 ; i<l ; i++)
			{
				ans.remove(0);
			}
		}
		
		if(ch=='5')
		{
			for(int i=0 ; i<l ; i++)
			{
				ans.add(ans.get(i)+"j");
				ans.add(ans.get(i)+"k");
				ans.add(ans.get(i)+"l");
			}
			
			for(int i=0 ; i<l ; i++)
			{
				ans.remove(0);
			}
		}
		
		if(ch=='6')
		{
			for(int i=0 ; i<l ; i++)
			{
				ans.add(ans.get(i)+"m");
				ans.add(ans.get(i)+"n");
				ans.add(ans.get(i)+"o");
			}
			
			for(int i=0 ; i<l ; i++)
			{
				ans.remove(0);
			}
		}
		
		if(ch=='7')
		{
			for(int i=0 ; i<l ; i++)
			{
				ans.add(ans.get(i)+"p");
				ans.add(ans.get(i)+"q");
				ans.add(ans.get(i)+"r");
				ans.add(ans.get(i)+"s");
			}
			
			for(int i=0 ; i<l ; i++)
			{
				ans.remove(0);
			}
		}
		
		if(ch=='8')
		{
			for(int i=0 ; i<l ; i++)
			{
				ans.add(ans.get(i)+"t");
				ans.add(ans.get(i)+"u");
				ans.add(ans.get(i)+"v");
			}
			
			for(int i=0 ; i<l ; i++)
			{
				ans.remove(0);
			}
		}
		
		if(ch=='9')
		{
			for(int i=0 ; i<l ; i++)
			{
				ans.add(ans.get(i)+"w");
				ans.add(ans.get(i)+"x");
				ans.add(ans.get(i)+"y");
				ans.add(ans.get(i)+"z");
			}
			
			for(int i=0 ; i<l ; i++)
			{
				ans.remove(0);
			}
		}
		
		
		
		
		
	}

}
