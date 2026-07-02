package BinaryTree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Main {

    static HashMap<Integer, Integer> mpp = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = inorder.length;
        int m = preorder.length;

        for(int i = 0 ; i < n;i++){
            mpp.put(inorder[i],i);
        }

        TreeNode root = build(preorder,0,m-1,inorder,0,n-1,mpp);

        return root;
    }
    private static TreeNode build(int [] preorder,int preStart,int preEnd,int [] inorder,int inStart,int inEnd,HashMap<Integer,Integer> mpp){

        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = mpp.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,mpp);
        root.right = build(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,mpp);

        return root;

    }

        
        

    // Inorder traversal to verify the constructed tree
    public static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
    }
}