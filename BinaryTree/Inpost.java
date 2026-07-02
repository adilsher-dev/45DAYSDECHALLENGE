package BinaryTree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Inpost{

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1,
                     postorder, 0, postorder.length - 1);
    }

    private static TreeNode build(int[] inorder, int inStart, int inEnd,
                                  int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd)
            return null;

        // Last element of postorder is the root
        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        // Build left subtree
        root.left = build(inorder, inStart, inRoot - 1,
                          postorder, postStart, postStart + numsLeft - 1);

        // Build right subtree
        root.right = build(inorder, inRoot + 1, inEnd,
                           postorder, postStart + numsLeft, postEnd - 1);

        return root;
    }

    // Inorder Traversal
    public static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    // Preorder Traversal
    public static void preorderTraversal(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // Postorder Traversal
    public static void postorderTraversal(TreeNode root) {
        if (root == null)
            return;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);

        System.out.print("Inorder: ");
        inorderTraversal(root);

        System.out.println();

        System.out.print("Preorder: ");
        preorderTraversal(root);

        System.out.println();

        System.out.print("Postorder: ");
        postorderTraversal(root);
    }
}