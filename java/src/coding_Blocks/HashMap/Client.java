package coding_Blocks.HashMap;

public class Client {

	public static void main(String[] args) throws Exception {

		
		HashTable<String , Integer> map = new HashTable<>(3);
		
		map.put("USA", 200);
		map.put("UK", 170);
		map.put("India", 300);
		map.put("China", 325);
		map.put("Sweden", 100);
		map.put("Nepal" , 70);

		map.put("India" , 325);
		map.display();
		
		map.put("England" , 170);
		map.display();
		
//		System.out.println(map.get("India"));
//		
//		System.out.print(map.remove("UK"));
//		map.display();
	
	
	}

}
