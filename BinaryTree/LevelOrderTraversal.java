package BinaryTree;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class LevelOrderTraversal{

    // Function to perform Level Order Traversal
    public static List<Integer> levelOrder(Node root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            Node current = q.poll();
            ans.add(current.data);

            if (current.left != null) {
                q.offer(current.left);
            }

            if (current.right != null) {
                q.offer(current.right);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> result = levelOrder(root);

        System.out.println("Level Order Traversal:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}