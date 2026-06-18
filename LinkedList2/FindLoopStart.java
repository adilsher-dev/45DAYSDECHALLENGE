package LinkedList2;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindLoopStart {

    static Node findStart(Node head) {
        Node slow = head;
        Node fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Move one pointer to head
                slow = head;

                // Find starting node
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null; // No cycle
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create loop: 5 -> 3
        head.next.next.next.next.next = head.next.next;

        Node start = findStart(head);

        if (start != null) {
            System.out.println("Loop starts at node: " + start.data);
        } else {
            System.out.println("No loop found");
        }
    }
}