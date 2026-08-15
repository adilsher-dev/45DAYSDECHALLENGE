package BST;

class Solution {

    TreeNode predecessor = null;
    TreeNode successor = null;

    public void findPreSuc(TreeNode root, int key) {

        TreeNode curr = root;

        // Find Predecessor
        while (curr != null) {

            if (curr.val < key) {
                predecessor = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        curr = root;

        // Find Successor
        while (curr != null) {

            if (curr.val > key) {
                successor = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }
}
