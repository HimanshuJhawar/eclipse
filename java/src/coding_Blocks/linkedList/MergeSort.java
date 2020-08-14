package coding_Blocks.linkedList;

import java.util.*;

public class MergeSort {

	private class Node {

		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int getFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("linked list is empty");

		return head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0)
			throw new Exception("linked list is empty");

		return tail.data;
	}

	public void addLast(int item) {
		// create a new node
		Node nn = new Node();

		nn.data = item;
		nn.next = null;

		// update summary
		if (size == 0) {
			this.head = nn;
			this.tail = nn;
			size++;
		} else

		{
			this.tail.next = nn;
			this.tail = nn;

			size++;
		}

	}

	public void addFirst(int item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		if (size == 0) {
			this.head = nn;
			this.tail = nn;
			size++;
		} else {
			nn.next = this.head;
			this.head = nn;
			size++;
		}

	}

	public int removeFirst() throws Exception {
		Node fn = this.head;

		if (this.size == 0)
			throw new Exception("linked list is empty");

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			size = 0;
		} else {
			Node np1 = this.head.next;
			this.head = np1;
			size--;
		}

		return fn.data;
	}

	public void merge_sorted_list(MergeSort ll) throws Exception {

		
		
//		System.out.print("Using Recursion -> ");
//		Node node1=new Node();
//		node1=this.head;
//		Node node2=new Node();
//		node2=ll.head;
//		this.head=SortedMerge(node1 , node2);
//		this.display();
//		this.head=node1;
		
		
		
		
		
		
		
		
		System.out.print("Using Loop -> ");
	    // dummy will make sorted MERGED new linkedlist 
	    Node dummyNode = new Node(); 
	      
	    // tail will make the new merged linked list whose head is dummyNode.next  
	    Node tail = dummyNode; 
	    while(true)  
	    { 
	          
	        /* if either list runs out,  
	        use the other list */
	        if(this.head == null) 
	        { 
	            tail.next = ll.head; 
	            break; 
	        } 
	        if(ll.head == null) 
	        { 
	            tail.next = this.head; 
	            break; 
	        } 
	         
	        
	        if(this.head.data <= ll.head.data) 
	        { 
	            tail.next = this.head; 
	            this.head = this.head.next; 
	        }  
	        else
	        { 
	            tail.next = ll.head; 
	            ll.head = ll.head.next; 
	        } 
	          
	        tail = tail.next; 
	    } 
	    
	    this.head=dummyNode.next;
	    this.display();
	    System.out.println();
	    
	    
	    
	    
	    
	    
	} 

	private Node SortedMerge(Node A, Node B)  
    { 
      
        if(A == null) return B; 
        if(B == null) return A; 
          
        if(A.data < B.data)  
        { 
            A.next = SortedMerge(A.next, B); 
            return A; 
        } 
        else 
        { 
            B.next = SortedMerge(A, B.next); 
            return B; 
        } 
          
    } 
	
	public void display() {

		Node temp = this.head;

		while (temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		System.out.println();

	}

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		    int t = scn.nextInt();
		    
		    while(t > 0)
		    {

			    MergeSort list1 = new MergeSort();
			    int n1 = scn.nextInt();
			 
			    for (int j = 0; j < n1; j++) 
			    {
				    int item = scn.nextInt();
				    list1.addLast(item);
			    }

			    MergeSort list2 = new MergeSort();
			    int n2 = scn.nextInt();
			 
			    for (int j = 0; j < n2; j++) 
			    {
				    int item = scn.nextInt();
				    list2.addLast(item);
			    }
			   list1.merge_sorted_list(list2);

			   t--;
            }
		
	}

}


//3
//5
//1 2 3 9 10
//4
//0 4 11 12
//3
//3 5 7
//5
//2 4 9 10 11
//3
//3 5 7
//3
//2 6 8
