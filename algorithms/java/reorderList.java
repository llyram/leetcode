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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        // find the middle of the linked list i.e. the start of the second half of the list.
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode second = slow.next; // store start of second half
        slow.next = null; // end of first half points to null now
        ListNode prev = null;

        // reverse the links of the second half of the list
        while(second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // Merge the two halves
        ListNode first = head;
        second = prev;
        while(second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }


    }
}