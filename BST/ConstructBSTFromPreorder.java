package BST;

public class ConstructBSTFromPreorder {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int index = 0;

    public static TreeNode build(int[] preorder, int min, int max) {
        if(index == preorder.length){
            return null;
        }

        int value = preorder[index];

        if(value < min || value > max){
            return null;
        }

        TreeNode root = new TreeNode(value);
        index++;

        root.left = build(preorder,min,value);
        root.right = build(preorder,value,max);

        return root;
        
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void preorder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        int[] preorder = {8, 5, 1, 7, 10, 12};

        TreeNode root = build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println("\n===============================");
        System.out.println("Constructed BST");

        System.out.print("Inorder : ");
        inorder(root);

        System.out.println();

        System.out.print("Preorder : ");
        preorder(root);
    }
}