/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node newhead = dummy;
        Node temp = head;

        Map<Node, Node> map = new HashMap<>();

        while(temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        newhead.next = map.get(head);
        newhead = newhead.next;

        while(temp != null) {
            newhead.next = map.get(temp.next);
            newhead.random = map.get(temp.random);

            newhead = newhead.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}