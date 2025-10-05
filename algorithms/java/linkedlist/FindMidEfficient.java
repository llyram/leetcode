package linkedlist;

import linkedlist.FindMid.Node;

public class FindMidEfficient {
	
	static class Node{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data=data;
		}
	}
	
	
	public static void main(String[] args)
	{
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		
		
		int mid = findmiddle(head);
		
		System.out.println(mid);
	}
	
	
	public static int findmiddle(Node head) {
		
		Node curr = head;
		Node purr = head;
		
		while(purr.next!=null || purr!=null)
		{
			curr=curr.next;
			purr= purr.next.next;
		}
		
		return curr.data;
	}

}
