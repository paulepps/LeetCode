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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        Deque<Integer> stack = new ArrayDeque<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode node;

        if (fast == null) {
            node = slow;
        } else {
            node = slow.next;
        }

        while (node != null) {
            if (node.val != stack.pop()) {
                return false;
            }
            node = node.next;
        }
        return true;
    }
}