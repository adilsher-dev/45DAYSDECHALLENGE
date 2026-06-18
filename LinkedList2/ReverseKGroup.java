package LinkedList2;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class ReverseKGroup {

    static Node getKthNode(Node temp,int k){
        k--;

        while(temp!=null && k > 0){
            temp = temp.next;
            k--;
        }
        return temp;
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    static Node reverseKGroup(Node head,int k){

        Node temp = head;
        Node prev = null;

        while(temp!=null){

            Node KthNode = getKthNode(temp,k);

            if(KthNode == null){
                if(prev!=null){
                    prev.next = temp;
                }
                break;
            }
            Node nextNode = KthNode.next;
            KthNode.next = null;

            reverse(temp);

            if(temp == head){
                head = KthNode;

            }
            else{
                prev.next = KthNode;
            }

            prev = temp;
            temp = nextNode;

        }
        return head;
    }
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        int k = 3;

        System.out.println("Original List:");
        printList(head);

        head = reverseKGroup(head, k);

        System.out.println("After Reversing in Groups of " + k + ":");
        printList(head);
    }
}
