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

        // Move fast pointer to the end, and slow to the middle of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Compare the reversed second half with the first half
        ListNode firstHalf = head;
        ListNode secondHalf = reverseList(slow);
        while (secondHalf != null) {
            // If values are different, then it's not a palindrome
            if (secondHalf.val != firstHalf.val) {
                return false;
            }

            // Move to the next nodes in both halves
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }

        // All values matched, so it's a palindrome
        return true;
    }

    private ListNode reverseList(ListNode current) {
        ListNode prev = null;

        while (current != null) {
            ListNode temp = current.next; // Stores the next node
            current.next = prev; // Reverses the link
            prev = current; // Moves prev to current node
            current = temp; // Move to the next node in the original list
        }
        return prev;
    }
}