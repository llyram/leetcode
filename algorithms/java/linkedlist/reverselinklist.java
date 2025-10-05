package linkedlist;
import java.util.*;

public class reverselinklist {

	static class Node{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data= data;
		}
	}
	
	
	public static void main(String[] arg)
	{
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		
		
		Node newhead = doreverse(head);
		printlinklist(newhead);
	}
	
	
	
	
	
	public static Node doreverse(Node head)
	{
		ArrayList<Integer> al = new ArrayList<>();
		Node curr = head;
		
		while(curr!=null)
		{
			al.add(curr.data);
			curr=curr.next;
		}
		
		
		//OPTION 1:
//		ArrayList<Integer> newal=reverse(al);     // revering the current arraylist, earlier i thought there's inbuild function, but it was not there, so build my own reverse function
//		
//		Node purr = head;
//		int i=0;
//		
//		while(purr!=null) {
//			purr.data = newal.get(i);
//			i++;
//			purr=purr.next;
//		}
//		
//		
//		return head;
		
		
		
		
		//OPTION2:
		 Node purr =head;
		 
		 
		 while(purr!=null)
		 {
			 purr.data = al.remove(al.size()-1);
			 purr = purr.next;
		 }
		 
		 return head;
	}
	
	
	
	
	
	public static ArrayList<Integer> reverse(ArrayList<Integer> al)
	{

		ArrayList<Integer> rl = new ArrayList<>();
	
		
		for(int i=al.size()-1; i>=0; i--)
		{
			rl.add(al.get(i));
		}
	//	System.out.print(rl);
		
		return rl;
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
