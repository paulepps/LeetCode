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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode previousNode = dummyHead;
      
        while (previousNode.next != null) {
            if (previousNode.next.val == val) {
                previousNode.next = previousNode.next.next;
            } else {
                previousNode = previousNode.next;
            }
        }
      
        return dummyHead.next;
    }
}