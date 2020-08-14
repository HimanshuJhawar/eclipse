package coding_Blocks.HashMap;

public class HashTable <K,V> {

	
	private class HTPair
	{
		K key ;
		V value;
		
		HTPair()
		{
			
		}
		
		HTPair(K key , V value)
		{
			this.key=key;
			this.value=value;
		}
		
		
		/* hamne overwrite isliye kiya kyunki jab ham genericlinkedlist class me find
		   function call karenge toh usme thisdata and other data compare honge , and data
		   me HTPair ke addresses store honge , kyunki array of linkedlist me linkedlist ke 
		   addresses store honge , and vaha par (.equals) call hoga toh voh HTPair ko compare karega
		   and HTPair ka and agar ham iss function ko override karte hai toh ham iss function ke 
		   according keys se compare kar sakte hai , varna agar ham override naa karte toh HTPair 
		   ke addresses compare ho jaate and answer change ho jaata 
		 */
		
		/* so that joh hamara criteria ho uss basis par equality ho */
		
		// Object class ke function ko override kiya hai
		@ Override
		public boolean equals(Object other)
		{
			HTPair otherpair = (HTPair) other;
			return this.key.equals(otherpair.key);
		}
		
		
		
		/* Yeh wala function hamne overwrite isliye kiya hai kyunki jab ham linkedlist me display function
		   call karenge toh display me data print hoga , but iss case me data me HTPair ka address store hoga
		   and HTPair me data stored hoga , toh isliye toString function of HTPair kaam aayega and voh asli 
		   data print kardega rather than an address
		*/
		
		/* so that display jaisa ham chaahe vaisa ho */
		
		@ Override
		public String toString() 
		{
			return "{" + this.key + " - " + this.value + "} =>"; 
		}
		
	}

	
	public static final int DEFAULT_CAPACITY=10;
	private GenericLinkedList<HTPair> [] bucketArray;
	private int size;
	
	
	public HashTable()
	{
		this(DEFAULT_CAPACITY);
	}
	
	
	public HashTable(int capacity)
	{
		this.bucketArray = (GenericLinkedList<HTPair>[]) new GenericLinkedList[capacity];
		this.size=0;
	}

	
	public void put(K key , V value) throws Exception
	{
		// index of array jisme store karwaana hai
		int bestindex = hashFunction(key);
		
		// uss index par padi linked list ko bula lo
		GenericLinkedList<HTPair> bucket = this.bucketArray[bestindex];
		
		// pta --> pair to be added in the linkedlist
		HTPair pta = new HTPair(key , value); 
		
		// if array at i'th index is empty or not
		if(bucket==null)
		{
			// if empty , then create new linkedlist , and then add new
			// element in it , and then put this linkedlist in array 
			bucket = new GenericLinkedList<>();
			bucket.addLast(pta);
			this.bucketArray[bestindex]=bucket;
			this.size++;
		}
		else
		{
			// check if element is present or not
			int find_index = bucket.find(pta);
	
			// if not present , then add that element in linkedlist
			if(find_index==-1)
			{
				bucket.addLast(pta);
				this.size++;
			}
			// if present , then update the (value) of that element
			else
			{
				HTPair abc = bucket.getAt(find_index);
				abc.value = value;
			}
			
		}
		
		
		double lambda = (this.size*1.0)/this.bucketArray.length;
		if(lambda>2)
		{
			this.rehash();
		}
		
	}
	
	
	private void rehash() throws Exception
	{
		GenericLinkedList<HTPair> [] old = this.bucketArray;
		this.bucketArray = (GenericLinkedList<HTPair>[]) new GenericLinkedList[2*old.length];
		this.size=0;
		for(GenericLinkedList<HTPair> oldList : old)
		{
			while(oldList!=null && !oldList.isEmpty())
			{
				HTPair pair = oldList.removeFirst();
				this.put(pair.key , pair.value);
			}
		}
	}

	
	public V get(K key) throws Exception
	{
		int bestindex=hashFunction(key);
		
		GenericLinkedList<HTPair> temp = this.bucketArray[bestindex];
		
		// ptf = pair to find
		HTPair ptf = new HTPair(key , null); 
		
		if(temp==null) return null;
		else
		{
			int findindex=temp.find(ptf);
			
			if(findindex==-1) return null;
			else 
			{
				HTPair abc = temp.getAt(findindex);
				return abc.value;
			}
		}
		
	}

	
	public V remove(K key) throws Exception
	{
		int bestindex=hashFunction(key);
		
		GenericLinkedList<HTPair> temp = this.bucketArray[bestindex];
		
		// ptr = pair to be removed
		HTPair ptr = new HTPair(key , null); 
		
		if(temp==null) return null;
		else
		{
			int findindex=temp.find(ptr);
			
			if(findindex==-1) return null;
			else 
			{
				HTPair a = temp.getAt(findindex);	
				HTPair b = temp.removeAt(findindex);
				this.size--;
				return a.value;
			}
		}
	}
	
	
	private int hashFunction(K key)
	{
		// internal function of java hai (.hashCode) , isse unique integer milega
		int hashcode = key.hashCode();
		
		// hashcode ko positive banana , because .hashCode function negative value bhi return kar sakta hai
		hashcode = Math.abs(hashcode);
		
		// modulus lelo array li length se
		int bestindex = hashcode % this.bucketArray.length;
		
		return bestindex;
	}

	
	public void display()
	{
		System.out.println();
		System.out.println("--------------------------------------");
		for(GenericLinkedList<HTPair> temp : this.bucketArray)
		{
			if(temp!=null)
			{
				temp.display();
			}
			else
			{
				System.out.println("NULL");
			}
			
		}
		System.out.println("--------------------------------------");	
	}
	
	
	
	
	
}
