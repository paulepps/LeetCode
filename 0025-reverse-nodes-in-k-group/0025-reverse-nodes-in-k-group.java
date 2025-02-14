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
        
        ListNode dummyNode = new ListNode(0, head);
        ListNode nodeBeforeReverse = dummyNode;
        ListNode curr = dummyNode;

        while (curr.next != null) {
            for (int i = 0; i < k && curr != null; i++) {
                curr = curr.next;
            }
            if (curr == null) {
                return dummyNode.next;
            } 

            ListNode nextTemp = curr.next;
            curr.next = null;
            ListNode start = nodeBeforeReverse.next;
            nodeBeforeReverse.next = reverseList(start);
            start.next = nextTemp;
            nodeBeforeReverse = start;
            curr = nodeBeforeReverse;
        }
        return dummyNode.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;  
        }
        return prev;
    }
}