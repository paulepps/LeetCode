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
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = reverseList(slow);
        while (secondHalf != null) {
            if (secondHalf.val != firstHalf.val) {
                return false;
            }

            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode current) {
        ListNode prev = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current; 
            current = temp; 
        }
        return prev;
    }
}