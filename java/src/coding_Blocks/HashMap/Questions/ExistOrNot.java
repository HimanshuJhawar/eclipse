package coding_Blocks.HashMap.Questions;

import java.util.*;

public class ExistOrNot {

	public static void main(String[] args) {

			Scanner sc=new Scanner(System.in);
			int t=sc.nextInt();
			for(int i=1 ; i<=t ; i++)
			{
				int l=sc.nextInt();
				HashMap<Integer,String> map=new HashMap<>();
				for(int j=0 ; j<l ; j++)
					map.put(sc.nextInt(), "Yes");
					
			    int q=sc.nextInt();
			    for(int k=1 ; k<=q ; k++)
			    {
			    	int find=sc.nextInt();
			    	if(map.containsKey(find))
			    		System.out.println(map.get(find));
			    	else
			    		System.out.println("No");
			    }
			}
	}

}
