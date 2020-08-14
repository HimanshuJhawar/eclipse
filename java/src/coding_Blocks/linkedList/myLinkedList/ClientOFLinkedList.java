package coding_Blocks.linkedList.myLinkedList;

public class ClientOFLinkedList {

	public static void main(String[] args) throws Exception {

		MyLinkedList mll=new MyLinkedList();
		
		mll.display();
		
		mll.addFirst(10);
		mll.addFirst(20);
		mll.addFirst(30);
		mll.addFirst(40);
		mll.addFirst(50);

		mll.addLast(60);
		mll.addLast(70);
		mll.addLast(80);

		mll.display();
		
		mll.reverseData();
		
		mll.display();
		
		mll.reversePointer();
		
		mll.display();
	}

}
