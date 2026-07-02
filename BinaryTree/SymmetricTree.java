package BinaryTree;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {

    public boolean isSymmetric(Node root) {
        if(root == null){
            return true;
        }
        return isSymmetricHelp(root.left,root.right);
    }
    private boolean isSymmetricHelp(Node left,Node right){
        
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        if(left.data != right.data){
            return false;
        }

        return isSymmetricHelp(left.left,right.right) && isSymmetricHelp(left.right,right.left);
    }
        
}

public class SymmetricTree {

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     2
             / \   / \
            3   4 4   3
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.left = new Node(4);
        root.right.right = new Node(3);

        Solution obj = new Solution();

        if (obj.isSymmetric(root))
            System.out.println("Tree is Symmetric");
        else
            System.out.println("Tree is Not Symmetric");
    }
}