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
    public ListNode partition(ListNode head, int x) {
        
        ListNode ltHead = new ListNode(0);
        ListNode gteHead = new ListNode(0);

        ListNode lt = ltHead;
        ListNode gte = gteHead;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                lt.next = curr;
                lt = lt.next;
            } else {
                gte.next = curr;
                gte = gte.next;
            } 
            curr = curr.next;
        }
        
        gte.next = null;
        lt.next = gteHead.next;

        return ltHead.next;
    }
}