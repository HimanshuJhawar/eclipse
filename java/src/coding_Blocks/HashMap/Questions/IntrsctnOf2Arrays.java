package coding_Blocks.HashMap.Questions;

import java.util.*;

public class IntrsctnOf2Arrays {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		int a[]=new int[n];
		int b[]=new int[n];
		
		for(int i=0 ; i<n ; i++)
			a[i]=sc.nextInt();
		
		for(int i=0 ; i<n ; i++)
			b[i]=sc.nextInt();
		
		
		HashMap<Integer , Integer> abc=new HashMap<>();
		
		for(int i:a){			
			if(abc.get(i)!=null)
				abc.put(i , abc.get(i)+1);
			else
				abc.put(i , 1);
		}
		
		
		ArrayList<Integer> al = new ArrayList<>();
		
		for(int i:b){
			if(abc.get(i)!=null) {
				if(abc.get(i)!=0)
				{
					al.add(i);
					abc.put(i , abc.get(i)-1);
				}
			}
				
		}
		
		Collections.sort(al);;
		System.out.println(al);
		
		
	}

}
