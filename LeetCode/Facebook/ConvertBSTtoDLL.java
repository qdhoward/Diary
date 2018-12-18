package LeetCode.Facebook;

import util.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConvertBSTtoDLL {
    private Node prev = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node(0, null, null);
        prev = dummy;
        helper(root);
        //connect head and tail
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private void helper (Node cur) {
        if (cur == null) return;
        helper(cur.left);
        prev.right = cur;
        cur.left = prev;
        prev = cur;
        helper(cur.right);
    }
//    public Node treeToDoublyList(Node root) {
//        if (root == null) {
//            return null;
//        }
//        Queue<Node> queue = new ArrayDeque<>();
//        inOrder(root, queue);
//        Node cur = queue.poll();
//        Node head = cur;
//        while (!queue.isEmpty()) {
//            Node prev = cur;
//            cur = queue.poll();
//            prev.right = cur;
//            cur.left = prev;
//        }
//        head.left = cur;
//        cur.right = head;
//        return head;
//    }
//    private void inOrder(Node root, Queue<Node> queue) {
//        if (root == null) {
//            return;
//        }
//        inOrder(root.left, queue);
//        queue.offer(root);
//        inOrder(root.right, queue);
//    }
}
