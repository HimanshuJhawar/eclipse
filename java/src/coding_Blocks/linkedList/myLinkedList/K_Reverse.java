package coding_Blocks.linkedList.myLinkedList;
import java.util.*;
public class K_Reverse {

	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public void LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	
	public void LinkedList(Node head, Node tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	// O(1)
	public int size() {
		return this.size;
	}

	// O(1)
	public boolean isEmpty() {
		return this.size() == 0;
	}

	// O(1)
	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty.");
		}

		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty.");
		}

		return this.tail.data;
	}

	// O(N)
	public int getAt(int idx) throws Exception {
		Node temp = this.getNodeAt(idx);
		return temp.data;
	}

	// O(N)
	private Node getNodeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		Node retVal = this.head;
		for (int i = 0; i < idx; i++) {
			retVal = retVal.next;
		}

		return retVal;
	}

	// O(1)
	public void addFirst(int data) {
		Node node = new Node(data, this.head);

		if (this.size() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.head = node;
		}

		this.size++;
	}

	// O(1)
	public void addLast(int data) {
		Node node = new Node(data, null);

		if (this.size() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;
	}

	// O(n)
	public void addAt(int idx, int data) throws Exception {
		if (idx < 0 || idx > this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size()) {
			this.addLast(data);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;

			Node node = new Node(data, n);
			nm1.next = node;

			this.size++;
		}
	}

	// O(1)
	public int removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		int retVal = this.head.data;

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;
		return retVal;
	}

	// O(n)
	public int removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		int retVal = this.tail.data;

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node sm2 = this.getNodeAt(this.size() - 2);
			sm2.next = null;
			this.tail = sm2;
		}

		this.size--;
		return retVal;
	}

	// O(n)
	public int removeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size() - 1) {
			return this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			this.size--;

			return n.data;
		}
	}

	// O(n)
	public void display() {
		Node node = this.head;
		
//		int size=this.size;
		while (node!=null) {
			System.out.print(node.data + " ");
			node = node.next;
//			size--;
		}
		System.out.println();
		//System.out.println("END");
	}
	
	
	public void reverse(int k){

    // Write your code here 
		
		// returning same list if k==1 , k==0 is not valid
		if(k==1 || k==0)
			return;
		
		// initialising previous start
		Node ps=this.head;
		// initialising current start
		Node cs=this.head;
		// initialising current end
		Node ce=this.head;

		
		// filling (curr end) properly
		Node temp=ce;
		for(int j=1 ; j<k ; j++)
		{
			temp=ce.next;
			ce=temp;
		}
		ce=temp;
		
		// initialising new head
		this.head=ce;
		
		
		// reversing k sized all lists available 
		for(int i=1 ; i<=this.size()/k ; i++)
		{
			Node prev=cs;
			Node curr=prev.next;
			Node ahead=curr.next;
			
			
			// reversing k size next elements
			for(int j=1 ; j<k ; j++)
			{				
				curr.next=prev;
								
				prev=curr;
				curr=ahead;
				if(ahead!=null)
				ahead=ahead.next;				
			}
			
			
			// fixing curr end
			ce=prev;
			
			
			// linking prev and curr k size reversed elements
			// i>1 because when i will be 1 , at that time there 
			// will be no prev element because that will be 1st iteration naaa!!!
			if(i>1)
			{
				ps.next=ce;
				ps=cs;
			}
			
			
			// fixing tail element , which will be in last iteration
			if(i==this.size()/k) 
			{
				cs.next=null;
				this.tail=cs;
			}	
			// fixing curr start for next round
			else
			{
				cs=curr;
			}
			
			
		}
		
	}
	
 

	public static void main(String[] args) throws Exception {
		
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
        int k = scn.nextInt();
		
		K_Reverse list = new K_Reverse();

		for (int i = 0; i < N; i++) {
			list.addLast(scn.nextInt());
		}

	    list.reverse(k);
		list.display();
}

}
