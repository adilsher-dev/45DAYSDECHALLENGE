package BST;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();
    private boolean reverse;

    public BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);

            if (reverse)
                node = node.right;
            else
                node = node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();

        if (reverse)
            pushAll(node.left);
        else
            pushAll(node.right);

        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

class Solution {

    public boolean findTarget(TreeNode root, int k) {

        if (root == null)
            return false;

        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {

            int sum = i + j;

            if (sum == k)
                return true;

            if (sum < k) {
                if (left.hasNext())
                    i = left.next();
                else
                    break;
            } else {
                if (right.hasNext())
                    j = right.next();
                else
                    break;
            }
        }

        return false;
    }
}

public class Main {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        Solution obj = new Solution();

        int target = 9;

        System.out.println(obj.findTarget(root, target));
    }
}