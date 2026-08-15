package BST;
//same logic lagega maxSum in a BST in a Binary Tree
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution{

    class NodeInfo{
    int min;
    int max;
    int size;

    NodeInfo(int min,int max,int size){
        this.min = min;
        this.max = max;
        this.size = size;
    }
}
    

    private NodeInfo solve(TreeNode root) {

        if(root == null){
            return new NodeInfo(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }

        NodeInfo left = solve(root.left);
        NodeInfo right = solve(root.right);

        if(left.max < root.val && root.val < right.min){

            return new NodeInfo(Math.min(root.val,left.min),Math.max(root.val,right.max),left.size + right.size + 1);
        }

        return new NodeInfo(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.size,right.size));
    }


    public int largestBST(TreeNode root) {
        return solve(root).size;
        
    }
}

public class LargestBst {

    public static void main(String[] args) {

        /*
                         50
                       /    \
                     30      60
                    /  \    /  \
                   5   20  45   70
                               /  \
                             65    80

        Largest BST:
                   60
                 /    \
               45      70
                      /  \
                    65    80

        Answer = 5
        */

        TreeNode root = new TreeNode(50);

        root.left = new TreeNode(30);
        root.right = new TreeNode(60);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);

        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);

        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);

        Solution obj = new Solution();

        System.out.println("Largest BST Size = " + obj.largestBST(root));
    }
}