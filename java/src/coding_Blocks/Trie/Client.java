package coding_Blocks.Trie;

public class Client {

	public static void main(String[] args) throws Exception {

			Trie trie = new Trie();
			
			trie.addWord("angry");
			trie.addWord("angel");
			trie.addWord("boys");
			trie.addWord("himanshu");
			trie.addWord("bro");
			trie.addWord("keshav");
			trie.addWord("bcdefg");
			
//			trie.display();
			
			System.out.println(trie.search("angel"));
			System.out.println(trie.search("keshav"));
			System.out.println(trie.search("abc"));
			
			
			trie.remove("keshav");
			trie.remove("himanshu");
			trie.remove("boys");
			
			trie.display();
//			trie.remove("hello");


	}

}
