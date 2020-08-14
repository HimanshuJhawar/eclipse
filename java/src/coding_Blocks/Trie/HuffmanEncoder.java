package coding_Blocks.Trie;
import java.util.*;
import coding_Blocks.Heap.Heap;
public class HuffmanEncoder {
	
	HashMap<Character , String> encoder = new HashMap<>();
	HashMap<String , Character> decoder = new HashMap<>();
	
	HuffmanEncoder(String feeder){
		
		// 1) Create frequency map of this feeder string
		HashMap<Character , Integer> fmap=new HashMap<>();
		
		for(int i=0 ; i<feeder.length() ; i++) {
			char cc=feeder.charAt(i);
			if(fmap.containsKey(cc)) {
				fmap.put(cc ,  fmap.get(cc)+1);
			} else {
				fmap.put(cc , 1);
			}
		}
		
		
		// 2) Create the minHeap of the trees
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		Set<Map.Entry<Character , Integer>> entryset = fmap.entrySet();
		for(Map.Entry<Character , Integer> entry : entryset) {
			Node node = new Node(entry.getKey() , entry.getValue());
			minHeap.add(node); 
		}
			
		
		// 3) Combine Nodes until one node is left in heap
		while(minHeap.size()!=1) {
			Node minone=minHeap.remove();
			Node mintwo = minHeap.remove();
			
			Node combine = new Node(minone , mintwo);
			combine.data='\0';
			combine.cost= minone.cost + mintwo.cost;
			
			minHeap.add(combine);
		}
		

		// 4) Take Out the last Node i.e FullTree Node
		Node fulltree=minHeap.remove(); 
		
		
		// 5) Fill Encoder and Decoder 
		this.initEncoderDecoder(fulltree , "");
		
		
			
 	}
	
	
	// filling my encoder and decoder
	private void initEncoderDecoder(Node node , String osf ) {
		
		if(node==null) return;
		
		if(node.left==null && node.right==null) {
			this.encoder.put(node.data , osf);
			this.decoder.put(osf , node.data);
		}
		
		this.initEncoderDecoder(node.left , osf+"0");
		this.initEncoderDecoder(node.right , osf+"1");

	}
	
	
	private class Node implements Comparable<Node>{
		char data;
		int cost;
		Node left;
		Node right; 
		
		Node(char data , int cost){
			this.data=data;
			this.cost=cost;
			this.left=null;
			this.right=null;
		}
		
		Node(Node left  ,  Node right){
			this.left=left;
			this.right=right;
		}

		@Override
		public int compareTo(Node o) {
			
			return this.cost-o.cost;
		}
	}


	public String encode(String source) {
		String rv="";
		
		for(int i=0 ; i<source.length() ; i++)
			rv += this.encoder.get(source.charAt(i));
		
		return rv;
	}

	
	public String decode(String codedString) {
		String rv="";
		String key="";
		for(int i=0 ; i<codedString.length() ; i++) {
			key = key + codedString.charAt(i);
			if(this.decoder.containsKey(key)) {
				rv = rv + this.decoder.get(key);
				key=""; 
			}
		}
		
		return rv;
	}



}
