package codingBlocks_section6_recursion.recursionPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Recursion_DictionaryOrder_Larger {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		
		int [] arr=new int[str.length()];
				
		for(int i=0 ; i<str.length() ; i++)
		{
			arr[i]=(int)str.charAt(i);
		}
		
		Arrays.sort(arr);
		
		String s="";
		
		for(int i=0 ; i<str.length(); i++)
		{
			s=s+(char)arr[i];
		}
		
		ArrayList<String> ma= rec(s);
		
		int x=0;
		for(int i=0 ; i<ma.size()-1; i++)
		{
			if(str.equals(ma.get(i)))
			{
				x=i;
				break;
			}
			
		}
		
		for(int i=x+1 ; i<ma.size() ; i++)
		{
			System.out.println(ma.get(i));
		}
		
		
		
	}
	
	
	static ArrayList<String> rec(String s)
	{
		ArrayList<String> ma=new ArrayList<>();
		ArrayList<String> ra=new ArrayList<>();

		if(s.length()==0)
		{
			ra.add("");
			return ra;
		}
		
		for(int j=0 ; j<s.length(); j++)
		{
		
			String a=s.substring(0,j) + s.substring(j+1) ;
			char cc=s.charAt(j);;
			
			ra=rec(a);
			
			for(int i=0 ; i<ra.size(); i++)
			{
				ma.add(cc+ra.get(i));
			}
		
		}

		
	
		
		return ma;

		
	}

}
