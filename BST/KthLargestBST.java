package BST;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class KthLargestBST {

    static int count = 0;
    static int ans = -1;

    public static void kthLargest(Node root, int k) {

        if (root == null) {
            return;
        }

        // Right
        kthLargest(root.right, k);

        // Root
        count++;
        if (count == k) {
            ans = root.data;
            return;
        }

        // Left
        kthLargest(root.left, k);
    }

    public static void main(String[] args) {

        // BST
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.left = new Node(6);
        root.right.right = new Node(8);

        int k = 3;

        kthLargest(root, k);

        System.out.println(k + "rd Largest Element = " + ans);
    }
}