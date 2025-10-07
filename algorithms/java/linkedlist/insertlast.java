package linkedlist;

import linkedlist.insertfirst.Node;

public class insertlast {

	static class Node
	{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data=data;
		}
	}
	
	public static void main(String[] arg)
	{
		Node head = new Node(10);
		head.next = new Node (20);
		head.next.next = new Node(30);
		
		Node newhead = insertlast(head,40);
		printlinklist(newhead);
	}
	
	
	public static Node insertlast(Node head, int item)
	{
		//in this first I will have to make a hold of last node
		Node itemnode = new Node(item);
		Node curr = head;
		
		while(curr.next!=null)
		{
			curr=curr.next;
		}
		
		curr.next=itemnode;
		itemnode.next=null;
		
		
		return head;
		
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
