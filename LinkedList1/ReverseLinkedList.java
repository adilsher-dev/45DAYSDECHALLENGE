package LinkedList1;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }


public static Node reverse(Node head) {
    Node prev = null;
    Node curr = head;

    while (curr != null) {
        Node front = curr.next;

        curr.next = prev;

        prev = curr;
        curr = front;
    }

    return prev;
}

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        head = reverse(head);

        System.out.println("\nReversed Linked List:");
        printList(head);
    }
}