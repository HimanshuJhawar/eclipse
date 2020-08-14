package coding_Blocks.HashMap;

public class GenericLinkedList<T> {

	
	private class Node
	{
		T data;
		Node next;
	}
	
	
	private Node head;
	private Node tail;
	private int size;
	
	
	public void display()
	{
		Node temp=this.head;
		
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.print("END");
		System.out.println();
	}
	
	public void addLast(T item)
	{
		// creating a new node
		Node nn=new Node();
		nn.data=item;
		nn.next=null;
		
		// attaching
		if(this.size>=1)
		{
			this.tail.next=nn;
		}
				
		// updating summary object
		if(this.size==0)
		{
			this.head=nn;
			this.tail=nn;
			this.size++;
		}
		else
		{
			size++;
			this.tail=nn;
		}
		
	}

	public void addFirst(T item)
	{
		// creating a new node
		Node nn=new Node();
		nn.data=item;
		nn.next=null;
	
		// attaching
		if(size>=1)
		{
			nn.next=this.head;
		}
		
		// updating summary object
		if(size==0)
		{
			this.head=nn;
			this.tail=nn;
			this.size++;
		}
		else
		{
			this.head=nn;
			this.size++;
		}
	}

	public void addAt(int index , T value) throws Exception
	{
		if(this.size>index || index<0)
		{
			throw new Exception ("Invalid Index");
		}
		
		// creating new node
		Node nn=new Node();
		nn.data=value;
		nn.next=null;
		
		if(this.size==1)
		{
			this.tail.next=nn;
			this.tail=nn;
			return;
		}
		
		
		// attaching
		Node curr=getNodeAt(index-1);
		Node ahead=curr.next;
		
		
		curr.next=nn;
		nn.next=ahead;
		
		// updating summary object
		this.size++;
	}

	public T getFirst() throws Exception
	{
		if(this.size==0) {
			throw new Exception ("LinkedList is Empty");
		}
		
		return this.head.data;		
	}
	
	public T getLast() throws Exception
	{
		if(this.size==0)
		{
			throw new Exception("LinkedList is Empty");
		}
		
		return this.tail.data;
	}

	public T getAt(int index) throws Exception
	{
		if(index>=this.size || index<0)
		{
			throw new Exception("Invalid Index");
		}
		
		Node temp=this.head;
		for(int i=1 ; i<=index ; i++)
		{
			temp=temp.next;
		}
		
		return temp.data;
		
	}

	public Node getNodeAt(int index) throws Exception
	{
		if(index>=this.size || index<0)
		{
			throw new Exception("Invalid Index");
		}
		
		Node temp=this.head;
		for(int i=1 ; i<=index ; i++)
		{
			temp=temp.next;
		}
		
		return temp;
		
	}

	public int find(T data)
	{
		int index=0;
		for(Node temp=this.head ; temp!=null ; temp=temp.next)
		{
			if(temp.data.equals(data))
				return index;
			index++;
		}
		
		return -1;
	}


	public T removeAt(int index)
	{
		if(this.head==null) return null;
		
		if(index==0) 
		{
			T b = this.head.data;
			this.head=this.head.next;
			this.size--;
			return b;
		}
		
		Node node = this.head;
		for(int i=0 ; i<index ; i++)
		{
			node=node.next;
		}
		
		System.out.println(node.next.data);
		T b=node.next.data;
		node.next=node.next.next;
		
		this.size--;
		return b;
	}


	public T removeFirst()throws Exception {
		if(this.head==null)
		{
			throw new Exception ("LinkedList is Empty");
		}
		
		T b = this.head.data;
		this.head=this.head.next;
		this.size--;
		return b;
	}

	public boolean isEmpty() {
		if(this.size==0) return true;
		return false;
	}

	


	
}
