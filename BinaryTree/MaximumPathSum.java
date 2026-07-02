package BinaryTree;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}


public class MaximumPathSum {

    static int maxi = 0;

    public static int maxPathSum(Node root){
        solve(root);
        return maxi;

    }
    private static int solve(Node root){
        if(root == null){
            return 0;
        }

        int left = Math.max(0,solve(root.left));
        int right = Math.max(0,solve(root.right));

        int currentSum = root.data + left + right;

        maxi = Math.max(maxi,currentSum);

        return root.data + Math.max(left,right);
    }
    
    public static void main(String[] args) {

        /*
                  10
                 /  \
                2   10
               / \    \
              20  1   -25
                      /  \
                     3    4
        */

        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);

        root.left.left = new Node(20);
        root.left.right = new Node(1);

        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        System.out.println("Maximum Path Sum = " + maxPathSum(root));
    }
}