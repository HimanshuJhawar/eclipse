package coding_Blocks.HashMap;

public class SubArrayWithSum0 {

	public static void main(String[] args) throws Exception {

		HashTable ht = new HashTable<Integer , Boolean>();
		
		int a[] = {1 , 2 , 3 , 4 , -7};
		int sum[] = {1 , 3 , 6 , 10 , 3};
		
		boolean ip=false;
		for(int i:sum)
		{
			if(ht.get(i)==null)
				ht.put(i , false);
			else
			{	
				ip=true;
				break;
			}	
		}
		
		System.out.println(ip);
		
		
	}

}
