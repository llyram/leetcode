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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while(head != null) {
            head.next = smallestNode(lists);
            head = head.next;
        }

        return dummy.next;
    }

    public ListNode smallestNode(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        ListNode ret = new ListNode();

        for(int i=0; i<lists.length; i++) {
            if(lists[i] == null) {
                continue;
            }
            min = Math.min(min, lists[i].val);
        }

        System.out.println(min);
        if (min == Integer.MAX_VALUE) {
            return null;
        }

        for(int i=0; i<lists.length; i++) {
            if(lists[i] == null) {
                continue;
            }
            if(min == lists[i].val) {
                ret = lists[i];
                lists[i] = lists[i].next;
                break;
            }
        }

        return ret;
        
    }


}