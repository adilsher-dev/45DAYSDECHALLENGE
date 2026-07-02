package BinaryTree;


class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BalancedBinaryTree {

    // Returns height if balanced, otherwise -1
    public static int height(Node root) {

        if(root == null){
            return 0;
        }

        int lh = height(root.left);

        if(lh == -1){
            return -1;
        }

        int rh = height(root.right);

        if(rh == -1){
            return -1;
        }

        if(Math.abs(lh - rh) > 1){
            return -1;
        }

        return 1 + Math.max(lh,rh);

    }
        

    public static boolean isBalanced(Node root) {
        return height(root) != -1;
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \
            4   5

            Balanced
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        if (isBalanced(root)) {
            System.out.println("Balanced Tree");
        } else {
            System.out.println("Not Balanced Tree");
        }
    }
}