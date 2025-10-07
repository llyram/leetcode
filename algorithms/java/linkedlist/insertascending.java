package linkedlist;

import linkedlist.reverseefficient.Node;

public class insertascending {
	
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
		
		
		Node newhead = insert(head,50);
		printlinklist(newhead);
	}
	
	
	public static Node insert(Node head, int key)
	{
		
		//There are 2 edge case always in teh linklist questions
		// edge case 1:  if the given "head node is null"
		// edge case 2: if the given linklist has only one node
		
		
		  Node itemnode = new Node(key);
	        
	        // Edge case 1: empty list
	        if (head == null) {
	            return itemnode;
	        }
	        
	        // Edge case 2: insert before head
	        if (key <= head.data) {
	            itemnode.next = head;
	            return itemnode;
	        }
	        
	        // General case: traverse to find correct position
	        Node curr = head;
	        while (curr.next != null && curr.next.data < key) {
	            curr = curr.next;
	        }
	        
	        // insert after curr
	        itemnode.next = curr.next;
	        curr.next = itemnode;
	        
	        return head;
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
