package coding_Blocks.Trie;

import java.util.*;

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
//			System.out.println(osf.substring(1) + parent.data);
			System.out.println(osf);
		}
		
		Set<Map.Entry<Character , Node>> entries = parent.children.entrySet();
		for(Map.Entry<Character , Node> entry : entries)
		{
//			this.display(entry.getValue() , osf+parent.data);
			this.display(entry.getValue() , osf+entry.getKey());
		}
	}


	public boolean search(String word)
	{
		return this.search(this.root , word);
	}
	private boolean search(Node parent , String word)
	{
		if(word.length()==0)
		{
			if(parent.isTerminal)
				return true;
			else
				return false;
		}
		
		char cc = word.charAt(0);
		String ros = word.substring(1);
		
		Node child = parent.children.get(cc);
		
		if(child==null)
			return false;

		return search(child , ros);
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
