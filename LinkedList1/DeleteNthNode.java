package LinkedList1;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteNthNode {

    // Delete nth node
    static Node deleteNthNode(Node head, int n) {


        Node temp = head;
        int count = 0;

        while(temp!=null){
            count++;
            temp = temp.next;
        }
        if(n > count){
            return head;
        }
        if(n==count){
            return head.next;
        }

        int k = count - n;

        temp = head;
        while(k>1){
            temp = temp.next;
            k--;
        }
        temp.next = temp.next.next;
        return head;
    }
        
    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Before Deletion:");
        printList(head);

        int n = 3;

        head = deleteNthNode(head, n);

        System.out.println("After Deletion:");
        printList(head);
    }
}