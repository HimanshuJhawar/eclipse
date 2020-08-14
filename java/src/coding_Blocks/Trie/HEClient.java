package coding_Blocks.Trie;

public class HEClient {

	public static void main(String[] args) {
		String s = "bac";
		
		HuffmanEncoder hf = new HuffmanEncoder(s);
		
		String encode=hf.encode(s);
		System.out.println(encode);
		
		String  output=hf.decode(encode);
		System.out.println(output);
	}

}
