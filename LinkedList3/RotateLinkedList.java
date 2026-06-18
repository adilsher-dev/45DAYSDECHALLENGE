package LinkedList3;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RotateLinkedList {

    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }

        return prev;
    }

    static Node rotateRight(Node head, int k) {

        if (head == null || head.next == null || k == 0){
            return head;
        }

        Node tail = head;
        int len = 1;

        while(tail.next != null){
            len++;
            tail = tail.next;
        }

        k = k % len;

        if(k == 0){
            return head;
        }

        int t = len - k;

        tail.next = head;

        Node temp = head;

        while( t > 1){
            t--;
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);

            if (head.next != null)
                System.out.print(" -> ");

            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;

        System.out.println("Original Linked List:");
        printList(head);

        head = rotateRight(head, k);

        System.out.println("After Rotation:");
        printList(head);
    }
}