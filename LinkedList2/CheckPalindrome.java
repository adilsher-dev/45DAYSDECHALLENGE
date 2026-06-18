package LinkedList2;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CheckPalindrome {

    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node front = current.next; // store next node
            current.next = prev;       // reverse link
            prev = current;            // move prev
            current = front;           // move current
        }

        return prev; // new head
    }

    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverse(slow.next);
        slow.next = null;
        Node first = head;
        Node second = newHead;

        while(second != null){

        if(first.data != second.data){
            reverse(newHead);
            return false;
        }
        first = first.next;
        second = second.next;

    }
    reverse(newHead);
    return true;
}

    
    public static void main(String[] args) {

    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(2);
    head.next.next.next.next = new Node(1);

    if (isPalindrome(head)) {
        System.out.println("Palindrome Linked List");
    } else {
        System.out.println("Not a Palindrome Linked List");
    }
}
}