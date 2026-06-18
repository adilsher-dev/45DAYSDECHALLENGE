package LinkedList1;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }


public static Node Middle(Node head) {

    if(head == null){
        return null;
    }
    if(head.next == null){
        return head;
    }

    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
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

        head = Middle(head);

        System.out.println("\nReversed Linked List:");
        printList(head);
    }
}
