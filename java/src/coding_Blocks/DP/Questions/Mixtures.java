package coding_Blocks.DP.Questions;

import java.util.*;

public class Mixtures {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0 ; i<n ; i++)
			al.add(sc.nextInt());
		System.out.println(Mixtures(al , Integer.MAX_VALUE , new HashMap<ArrayList<Integer> , Integer>() ));
		
	}

	static int Mixtures(ArrayList<Integer> al , int min , HashMap<ArrayList<Integer> , Integer> hm )
	{
		if(al.size()==1) return al.get(0);
		if(al.size()==2) return al.get(0)*al.get(1); 
		
		Set<ArrayList<Integer>> keys = hm.keySet();
		for(ArrayList<Integer> key : keys)
		{
//			System.out.print(key+" , ");
//			System.out.println(al);
			if(key.equals(al))
			{
//				System.out.println("hi");
				return hm.get(key);
			}
		}	
			
		for(int j=0 ; j<al.size()-1 ; j++)
		{	
//			System.out.println("HI");
			int c=al.remove(j);
			int d=al.remove(j);
			al.add(j, (c+d)%100);
		
			int temp2=c*d + Mixtures(al , min , hm);
			if(min>temp2)
				min=temp2;
			
			al.remove(j);
			al.add(j , d);
			al.add(j , c);
		}
		
		ArrayList<Integer> dp = new ArrayList<>();
		dp.addAll(al);
		hm.put(dp , min);
		
		return min;
	}

	
}
