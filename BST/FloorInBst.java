package BST;

public class FloorInBst {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int floor(TreeNode root, int key) {
        int floor =  -1;

        while(root != null){

            if(root.val == key){
                return root.val;
            }

            if(root.val < key){
                floor = root.val;
                root = root.right;
            }
            else{
                root = root.left;

            }
        }
        return floor;
    }

    public static void main(String[] args) {

        /*
                  8
                /   \
               4     12
              / \    / \
             2   6  10 14
        */

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        System.out.println(floor(root, 11)); // 10
    }
}