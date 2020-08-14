package coding_Blocks.linkedList.myLinkedList;

public class MyLinkedList {

	
	private class Node
	{
		int data;
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
		System.out.println();
	}
	
	public void addLast(int item)
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

	public void addFirst(int item)
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

	public int getFirst() throws Exception
	{
		if(this.size==0) {
			throw new Exception ("LinkedList is Empty");
		}
		
		return this.head.data;		
	}
	
	public int getLast() throws Exception
	{
		if(this.size==0)
		{
			throw new Exception("LinkedList is Empty");
		}
		
		return this.tail.data;
	}

	public int getAt(int index) throws Exception
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

	public void addAt(int index , int value) throws Exception
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

	public void reverseData() throws Exception
	{
		Node start=head;
		Node last=tail;
		
		for(int i=0 ; i<size/2 ; i++)
		{
			int change=start.data;
			start.data=last.data;
			last.data=change;
			
			start=start.next;
			last=getNodeAt(size-1-i-1);
		}
	}

	public void reversePointer()
	{
		if(size==1 || size==2)
		{
			Node temp=head;
			this.head=this.tail;
			this.tail=temp;
			
			head.next=tail;
			tail.next=null;
			
			return;
		}
		
		Node prev=head;
		Node curr=head.next;
		Node ahead=curr.next;
		
		prev.next=null;
		while(ahead!=null)
		{
			curr.next=prev;
			
			prev=curr;
			curr=ahead;
			ahead=ahead.next;
		}
		curr.next=prev;
		
		Node temp=head;
		head=tail;
		tail=temp;
	}
	
}
