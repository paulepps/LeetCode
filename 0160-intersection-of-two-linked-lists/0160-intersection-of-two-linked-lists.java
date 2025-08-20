/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = 0;
        int lenB = 0;

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != null) {
            lenA++;
            nodeA = nodeA.next;
        }

        while (nodeB != null) {
            lenB++;
            nodeB = nodeB.next;
        }

        nodeA = headA;
        nodeB = headB;

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                nodeA = nodeA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                nodeB = nodeB.next;
            }
        }

        while (nodeA != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return null;
    }
}