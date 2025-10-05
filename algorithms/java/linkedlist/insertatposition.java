package linkedlist;

import linkedlist.insertlast.Node;

public class insertatposition {
	
	static class Node
	{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data=data;
			next = null;
		}
	}
	
	
	public static void main(String arg[])
	{
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		
		Node newhead = insertNode(head,25,5);
		printlinklist(newhead);
		
		
		
		
	}
	
	
	public static Node insertNode(Node head, int item, int p)
	{
		int pos=1;
		Node curr=head;
		Node itemnode = new Node(item);
		
		if(pos == p)
		{
			itemnode.next = curr;
			return itemnode;
		}
		
		while(pos<p-1)
		{ 
		
				curr=curr.next;
				pos++;
			
		
			
		}
		
	   itemnode.next = curr.next;
	   curr.next=itemnode;
	    
	    
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
