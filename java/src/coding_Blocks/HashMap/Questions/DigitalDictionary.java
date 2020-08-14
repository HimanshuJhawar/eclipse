package coding_Blocks.HashMap.Questions;
import java.util.*;
import java.util.Map.Entry;
public class DigitalDictionary {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		DigitalDictionary m=new DigitalDictionary();
		Trie dd=m.new Trie();
		
		int N=sc.nextInt();
		String space = sc.nextLine();
		for(int i=1 ; i<=N ; i++)
			dd.addWord(sc.nextLine());
		
		
		int q=sc.nextInt();
		String space2=sc.nextLine();
		for(int i=1 ; i<=q ; i++)
		{
			String prefix=sc.nextLine();
			dd.search(prefix);
		}
		
	}

	
	public class Trie {

		
		private class Node
		{
			char data;
			HashMap<Character , Node> children;
			boolean isTerminal;
			
			Node(char data , boolean isTerminal)
			{
				this.data=data;
				this.children=new HashMap<>();
				this.isTerminal=isTerminal;
			}
		}

		
		private int numWords;
		private Node root;
		
		
		Trie()
		{
			this.root=new Node('\0' , false);
			this.numWords=0;
		}

		
		public int numWords()
		{
			return this.numWords;
		}

		
		public void addWord(String word)
		{
			this.addWord(this.root , word);
		}
		private void addWord(Node parent , String word)
		{
			if(word.length()==0)
			{
				if(parent.isTerminal)
				{
					// word already exists
				}
				else
				{
					parent.isTerminal=true;
					this.numWords++;
				}
				return;
			}
			
			 char cc=word.charAt(0);
			 String ros=word.substring(1);
			 Node child = parent.children.get(cc);
			 
			 if(child==null)
			 {
				 child = new Node(cc , false);
				 parent.children.put(cc, child);
			 }
			 
			 this.addWord(child , ros);
		}


		public void display()
		{
			this.display(this.root , "");
		}
		private void display(Node parent , String osf)    // osf = output so far
		{
			if(parent.isTerminal)
			{
//				System.out.println(osf.substring(1) + parent.data);
				System.out.println(osf);
			}
			
	         TreeMap<Character, Node> entries = new TreeMap<>(parent.children); 
	         Set<Entry<Character, Node>> set2 = entries.entrySet();

			for(Map.Entry<Character , Node> entry : set2)
			{
//				this.display(entry.getValue() , osf+parent.data);
				this.display(entry.getValue() , osf+entry.getKey());
			}
		}


		public boolean search(String word)
		{
			return this.search(this.root , word , word);
		}
		private boolean search(Node parent , String word , String actual)
		{
			if(word.length()==0)
			{
//				if(parent.isTerminal)
//					return true;
//				else
//					return false;

				this.display(parent , actual);
				 return true;
			}
			
			char cc = word.charAt(0);
			String ros = word.substring(1);
			
			Node child = parent.children.get(cc);
			
			if(child==null)
			{
				this.addWord(actual);
				System.out.println("No suggestions");
				return true;
			}
			return search(child , ros , actual);
		}
		
		
		public void remove(String word) throws Exception
		{
			this.remove(this.root , word);
		}
		private void remove(Node parent , String word) throws Exception
		{
			if(word.length()==0)
			{
				if(parent.isTerminal)
				{
					parent.isTerminal=false;
					this.numWords--;
				}
				else
				{
					// this character is a part of some other word
				}
				
				return;
			}
			
			String ros = word.substring(1);
			char cc=word.charAt(0);
			
			Node child = parent.children.get(cc);
			
			if(word.length()!=0 && child==null)
				throw new Exception("Word not Pressent");
			
			this.remove(child , ros);
			
			if(!child.isTerminal && child.children.isEmpty())
			{
				parent.children.remove(cc);
			}
			
			
		}

		
		
		
	}

	
	
}


