package BinaryTree;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class DiameterBinaryTree {
    static int diameter = 0;

    public static int maxDepth(Node root){
        if(root == null){
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        diameter = Math.max(diameter,lh + rh);

        return 1 + Math.max(lh,rh);
    }

    public static int Dia(Node root){
        maxDepth(root);
        return diameter;
    }


    
    
    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \     \
            4   5     6
           /
          7

        Diameter = 5 edges
        Path: 7 -> 4 -> 2 -> 1 -> 3 -> 6
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        root.left.left.left = new Node(7);

        System.out.println("Diameter = " + Dia(root));
    }
}