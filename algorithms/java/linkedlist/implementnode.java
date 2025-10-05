package linkedlist;

public class implementnode {
	
	static class Node{
		
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
		}
	}
	
	
	
	public static void main(String[] arg)
	{
		Node head= new Node(10);
		head.next= new Node(20);
		head.next.next = new Node(30);
		head.next.next.next= new Node(40);
		
		printlinklist(head);
	}
	
	public static void printlinklist(Node head) {
		
		Node curr = head;
		
		while(curr!=null)
		{
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
	}
	

}
