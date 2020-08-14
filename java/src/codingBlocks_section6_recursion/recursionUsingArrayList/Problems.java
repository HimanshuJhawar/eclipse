package codingBlocks_section6_recursion.recursionUsingArrayList;

import java.util.ArrayList;

public class Problems {

	public static void main(String[] args) {

		System.out.println(getPermutation("abc"));
		
		System.out.println(boardPath(0,10));
		
		System.out.println(mazePath(0,0,2,2));

		System.out.println(mazePathDiagonal(0,0,2,2));

		
	}
	
	
	
	
	static ArrayList<String> getPermutation(String s)
	{
		ArrayList<String> ans=new ArrayList<>();
		
		if(s.length()==0) 
			{
			ans.add("");
			return ans;
			}
		
		
		char cc=s.charAt(0);
		String sbs=s.substring(1);
		
		
		ArrayList<String> recans=getPermutation(sbs);
		
		
		for(int j=0 ; j<recans.size(); j++)
		{
			for(int i=0 ; i<=recans.get(j).length(); i++)
			{
				ans.add(recans.get(j).substring(0,i) + cc + recans.get(j).substring(i));
			}
		
		}
		
		
		return ans;
		
	}
	
	
	static ArrayList<String> boardPath(int current , int end)
	{
		ArrayList<String> recans=new ArrayList<>();
		ArrayList<String> ans=new ArrayList<>();
	
		if(current>end) return recans;
				
		if(current==end)
		{
			recans.add("");
			return recans;
		}
		
		
		for(int dice=1 ; dice<=6 ; dice++)
		{
		recans=boardPath(current+dice,end);
		
		for(int j=0 ; j<recans.size(); j++)
			ans.add(dice + recans.get(j));
		}
		return ans;
	}

	
	static ArrayList<String> mazePath(int sH , int sV , int eH , int eV )
	{
		ArrayList<String> recans=new ArrayList<>();
		ArrayList<String> ans=new ArrayList<>();
	
		if(sH>eH||sV>eV) return recans;
				
		if(sH==eH&&sV==eV)
		{
			recans.add("");
			return recans;
		}
		
		recans=mazePath(sH+1,sV,eH,eV);
			for(int j=0 ; j<recans.size(); j++) ans.add("H" + recans.get(j));
		
		recans=mazePath(sH,sV+1,eH,eV);
			for(int j=0 ; j<recans.size(); j++) ans.add("V" + recans.get(j));
			
		return ans;
	}

	
	static ArrayList<String> mazePathDiagonal(int sH , int sV , int eH , int eV )
	{
		ArrayList<String> recans=new ArrayList<>();
		ArrayList<String> ans=new ArrayList<>();
	
		if(sH>eH||sV>eV) return recans;
				
		if(sH==eH&&sV==eV)
		{
			recans.add("");
			return recans;
		}
		
		recans=mazePathDiagonal(sH+1,sV,eH,eV);
			for(int j=0 ; j<recans.size(); j++) ans.add("H" + recans.get(j));
		
		recans=mazePathDiagonal(sH,sV+1,eH,eV);
			for(int j=0 ; j<recans.size(); j++) ans.add("V" + recans.get(j));
			
		recans=mazePathDiagonal(sH+1,sV+1,eH,eV);
			for(int j=0 ; j<recans.size(); j++) ans.add("D" + recans.get(j));
		
		return ans;
	}
	
	
	
}
