package linkedlist;

import java.util.ArrayList;

public class FindMid {
	
	static class Node{
		
		Node next;
		int data;
		
		Node(int d)
		{
			data=d;
		}
	}
	
	
	public static void main(String[] args)
	{
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		
		
		int mid = findlinklistmiddle(head);
		System.out.print(mid);
	}
	
	public static int findlinklistmiddle(Node head)
	{
		ArrayList<Integer> al = new ArrayList<>();
		Node curr = head;
		
		while(curr!=null)
		{
			al.add(curr.data);
			curr = curr.next;
			
		}
		
		return al.get(al.size()/2);
		
	}
}
