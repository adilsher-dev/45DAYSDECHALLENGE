package BinaryTree;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class ZigzagTraversal {

    public static List<List<Integer>> zigzag(Node root) {

        List<List<Integer>> ans =  new ArrayList<>();

        if(root == null){
            return ans;
        }
        boolean LTOR = true;

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size;i++){

                Node curr = q.poll();
                temp.add(curr.data);


                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            if(!LTOR){
             Collections.reverse(temp);
            }
            ans.add(temp);
            LTOR = !LTOR;
        }
        return ans;
    }
    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> ans = zigzag(root);

        System.out.println(ans);
    }
}