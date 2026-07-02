package BST;

public class ValidateBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode root, long min, long max) {

        if(root == null){
            return true;
        }

        if(root.val <= min || root.val >= max){
            return false;
        }

        return validate(root.left,min,root.val) && validate(root.right,root.val,max);

    
    }

    public static void main(String[] args) {

        /*
                  8
                /   \
               5     10
              / \      \
             1   7      12
        */

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(5);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(12);

        System.out.println(isValidBST(root)); // true
    }
}