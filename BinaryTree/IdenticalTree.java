package BinaryTree;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class IdenticalTree {

    // Function to check if two trees are identical
    public static boolean isIdentical(Node root1, Node root2) {

        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.data != root2.data){
            return false;
        }
        return isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
    }

    public static void main(String[] args) {

        // Tree 1
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        // Tree 2
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);

        if (isIdentical(root1, root2)) {
            System.out.println("Trees are Identical");
        } else {
            System.out.println("Trees are Not Identical");
        }
    }
}