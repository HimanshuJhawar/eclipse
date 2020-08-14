package coding_Blocks.HashMap.Questions;
import java.util.*;
public class HighestFrequency {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int a[]=new int[n];
		
		for(int i=0 ; i<n ; i++)
			a[i]=sc.nextInt();
		
		int max=1;
		int ans=0;
		
		HashMap<Integer , Integer> abc = new HashMap<>();
		
		for(int i:a)
		{
			if(abc.get(i)!=null)
			{
				abc.put(i , abc.get(i)+1);
				if(max<abc.get(i))
				{
					max=abc.get(i);
					ans=i;
				}
			}
			else
			{
				abc.put(i , 1);
			}
		}
		
		System.out.println(ans);
	}

}
