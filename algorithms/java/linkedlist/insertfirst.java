package linkedlist;

public class insertfirst {
	
	static class Node{
		int data;
		Node next;
		
		
		Node(int data)
		{
			this.data = data;
			next=null;
		}
	}
	
	public static void main(String[] arg)
	{
		Node head = new Node(10);
		head.next = new Node (20);
		head.next.next = new Node(30);
		
		Node newhead = insertstart(head,5);
		printlinklist(newhead);
	}
	
	
	public static Node insertstart(Node head, int item)
	{
		Node itemnode = new Node(item);
		itemnode.next=head;
		
		return itemnode;
		
	}
	
	
	public static void printlinklist(Node newhead)
	{
		Node curr = newhead;
		
		while(curr!=null)
		{
			System.out.print(curr.data+ "->");
			curr=curr.next;
		}
		System.out.print("null");
		
	}

}
