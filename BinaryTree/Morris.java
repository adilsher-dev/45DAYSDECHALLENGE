package BinaryTree;
//Inorder
import java.util.List;
import java.util.ArrayList;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class Morris {
    public static List<Integer> morris(Node root){

        List<Integer> ans = new ArrayList<>();

        Node curr = root;

        while(curr != null){
            if(curr.left == null){
                ans.add(curr.data);
                curr = curr.right;
            }
            else{

                Node pred = curr.left;

                while(pred.right != null && pred.right != curr){
                    pred = pred.right;

                }

                    if(pred.right == null){
                        pred.right = curr;
                        curr = curr.left;

                    }
                    else{
                        pred.right = null;
                        ans.add(curr.data);
                        curr = curr.right;
                    }
                }
            }
        return ans;
    }
public static void main(String[] args) {

        /*
                 4
               /   \
              2     6
             / \   / \
            1   3 5   7
        */

        Node root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(6);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right.left = new Node(5);
        root.right.right = new Node(7);

        List<Integer> ans = morris(root);

        System.out.println("Morris Inorder Traversal:");
        System.out.println(ans);
    }
}