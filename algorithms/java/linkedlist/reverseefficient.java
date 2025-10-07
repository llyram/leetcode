package linkedlist;

import linkedlist.reverselinklist.Node;

public class reverseefficient {
	
	static class Node
	{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data = data;
		}
	}
	
	
	public static void main(String[] arg)
	{
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		
		
		Node newhead = reverselinklist(head);
		printlinklist(newhead);
	}
	
	
	public static Node reverselinklist(Node head)
	{
		Node curr=head;
		Node prev = null;
		
		while(curr!=null)
		{
			Node next = curr.next;
			curr.next = prev;
			
			prev=curr;
			curr = next;
		}
		
		return prev;
	}
	
	public static void printlinklist(Node head)
	{
		Node curr = head;
		
		while(curr!=null)
		{
			System.out.print(curr.data + "->");
			curr=curr.next;
		}
		System.out.print("null");
		
	}

}
