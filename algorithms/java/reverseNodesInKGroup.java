/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);

        ListNode groupPrev = dummy;
        ListNode groupNext;

        while(true) {

            // Get the Kth Node
            int count = 0;
            ListNode kth = groupPrev;
            while(kth != null && count < k) {
                kth = kth.next;
                count++;
            }
            // End

            // If Kth node is null meaning we reached the end of list then break
            if(kth == null) {
                break;
            }

            groupNext = kth.next;

            // Reverse the Linked List group
            ListNode prev = groupNext, curr = groupPrev.next;
            while(curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            // End

            ListNode tmp = groupPrev.next;
            groupPrev.next = kth; // kth becomes first node of the group
            groupPrev = tmp;
        }    
        return dummy.next;   
    }
}