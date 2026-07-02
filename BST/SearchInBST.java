package BST;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

class Solution {

    public Node searchBST(Node root, int val) {

        if(root == null || root.val == val){
            return root;
        }
        if(root.val < val){
            root = searchBST(root.right,val);
        }
        else if(root.val > val){
            root =  searchBST(root.left,val);
        }
        else{
            return root;
        }
        return root;
        } 
}

public class SearchInBST {

    public static void main(String[] args) {

        /*
                  8
                /   \
               3     10
              / \      \
             1   6      14
                / \     /
               4   7   13
        */

        Node root = new Node(8);

        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);

        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        Solution obj = new Solution();

        int key = 6;

        Node ans = obj.searchBST(root, key);

        if (ans != null)
            System.out.println("Node Found : " + ans.val);
        else
            System.out.println("Node Not Found");
    }
}