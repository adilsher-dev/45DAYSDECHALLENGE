package BinaryTree;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}

public class LeftSide {

    public static List<Integer> leftSideView(Node root){

        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size;i++){
                Node curr = q.poll();

                if(i == 0){
                   ans.add(curr.data);
                }

                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
                
            }

        }
        return ans;
    }
    public static void main(String[] args){

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        root.left.right.left = new Node(7);

        System.out.println("Left View : " + leftSideView(root));
    }
}
