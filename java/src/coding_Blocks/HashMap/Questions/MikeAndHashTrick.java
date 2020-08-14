package coding_Blocks.HashMap.Questions;
import java.util.*;
public class MikeAndHashTrick {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int A[] = new int[n];
		for(int i=0 ; i<n ; i++)
			A[i]=sc.nextInt();
		
		HashMap<Integer , Integer> map = new HashMap<>();
		ArrayList<Integer> al = new ArrayList<>();
		
		for(int i=0 ; i<n ; i++) 
		{
		    al.add(A[i]);
		    
			if(map.containsKey(A[i])) 
			    al.set(map.get(A[i]), -1);
	
		    map.put(A[i] , al.size()-1);
		}
		
		
		for(int i=0 ; i<al.size(); i++) 
		{
			if(al.get(i)!=-1)
				System.out.println(al.get(i));
		}
	
	}
	

}


