package BST;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class LCAinBST {

    public static Node lca(Node root, Node p, Node q) {

        if(root == null){
            return null;
        }


        if(p.val > root.val && q.val > root.val){
            return lca(root.right,p,q);
        }
        else if(p.val < root.val && q.val < root.val){
            return lca(root.left,p,q);
        }
        else{
            return root;
        }
        }
    
    public static void main(String[] args) {

        // Constructing BST
        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(8);

        root.left.left = new Node(0);
        root.left.right = new Node(4);

        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

        root.right.left = new Node(7);
        root.right.right = new Node(9);

        Node p = root.left;              // 2
        Node q = root.left.right;        // 4

        Node ans = lca(root, p, q);

        System.out.println("LCA is: " + ans.val);
    }
}