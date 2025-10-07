package linkedlist;

import linkedlist.implementnode.Node;

public class searchnode {

	static class Node
	{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data = data;
			next=null;
		}
	}
	
	public static void main(String[] args)
	{
		Node head= new Node(10);
		head.next= new Node(20);
		head.next.next = new Node(30);
		head.next.next.next= new Node(40);
		
		
		int position = searchPosition(head, 40);
		if(position>0)
		{
			System.out.print("Node found at position :"+ position);
		}
		else
		{
			System.out.print("Node not found");
		}		
	}
	
	public static int searchPosition(Node head, int item)
	{
		int pos=1;
		Node curr = head;
		
		
			while(curr!=null)
			{
				if(curr.data == item)
				{
					return pos;
				}
				else
				{
					curr=curr.next;
					pos++;
							
				}
			}
			
			return -1;
		
	}
	
	
}
