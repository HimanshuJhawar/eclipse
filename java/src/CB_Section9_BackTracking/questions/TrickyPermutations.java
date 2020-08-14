package CB_Section9_BackTracking.questions;

import java.util.*;

public class TrickyPermutations {

	static ArrayList<String> arr=new ArrayList<>();
	
	public static void main(String[] args) {

		
		
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
	
		tp(s,"");
		
		Collections.sort(arr);
		
		for(int i=0 ; i<arr.size()-1; i++)
		{
			if(!arr.get(i).equals(arr.get(i+1)))
				System.out.println(arr.get(i));
		}
		
		//if(!arr.get(arr.size()-2).equals(arr.get(arr.size()-1)))			jaroorat nahi hai , last wala toh print hoga har case mein
			System.out.println(arr.get(arr.size()-1));
		
	}
	
	
	static void tp(String s , String ans)
	{
		if(s.length()==0)
		{
			arr.add(ans);
			return;
		}
		
		
		for(int i=0 ; i<s.length(); i++)
		{
			tp(  s.substring(0,i)+s.substring(i+1) , ans+s.charAt(i)  );
		}
		
	}
	
	

}
