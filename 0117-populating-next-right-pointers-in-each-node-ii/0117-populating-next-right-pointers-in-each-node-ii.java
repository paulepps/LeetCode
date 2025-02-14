/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    private Node prev;
    private Node next;

    public Node connect(Node root) {
        
        Node curr = root;

        while (curr != null) {
            prev = null;
            next = null;

            while (curr != null) {
                modifyPointer(curr.left);
                modifyPointer(curr.right);

                curr = curr.next;
            }
            curr = next;
        }
        return root;
    }

    private void modifyPointer(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        if (next == null) {
            next = currentNode;
        }

        if (prev != null) {
            prev.next = currentNode;
        }

        prev = currentNode;
    }
}