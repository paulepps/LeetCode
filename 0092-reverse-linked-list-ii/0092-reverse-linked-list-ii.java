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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if (head.next == null || left == right) {
            return head;
        }

        ListNode dummyNode = new ListNode(0, head);

        ListNode nodeBeforeReverse = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            nodeBeforeReverse = nodeBeforeReverse.next;
        }

        ListNode firstReversed = nodeBeforeReverse.next;
        ListNode curr = firstReversed;
        ListNode prev = null;

        for (int i = 0; i < right - left + 1; i++) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        nodeBeforeReverse.next = prev;
        firstReversed.next = curr;

        return dummyNode.next;
    }
}