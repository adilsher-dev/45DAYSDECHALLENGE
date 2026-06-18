package LinkedList2;

class Node {
    int data;
    Node next;
    Node child;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }
}

public class FlattenLinkedList {

    static Node merge(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node curr = dummy;

        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                curr.child = list1;
                curr = list1;
                list1 = list1.child;
            }
            else{
                curr.child = list2;
                curr = list2;
                list2 = list2.child;
            }
        }
        curr.child = null;

        if(list1 != null){
            curr.child = list1;
        }
        else{
            curr.child = list2;
        }

        if(dummy.child != null){
            dummy.child.next = null;
        }
        return dummy.child;
    }

    static Node flattenLinkedList(Node head) {

        if(head == null || head.next == null){
            return head;
        }

        Node mergeHead = flattenLinkedList(head.next);

        head = merge(mergeHead,head);
        
        return head;

        
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(5);
        head.child = new Node(7);
        head.child.child = new Node(8);
        head.child.child.child = new Node(30);

        head.next = new Node(10);
        head.next.child = new Node(20);

        head.next.next = new Node(19);
        head.next.next.child = new Node(22);
        head.next.next.child.child = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.child = new Node(35);
        head.next.next.next.child.child = new Node(40);
        head.next.next.next.child.child.child = new Node(45);

        Node flatHead = flattenLinkedList(head);

        System.out.println("Flattened Linked List:");
        printList(flatHead);
    }
}