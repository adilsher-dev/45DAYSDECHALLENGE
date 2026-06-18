package LinkedList2;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class IntersectionOfLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode t1 = headA;
        ListNode t2 = headB;

        while(t1!=t2){

            if(t1 == t2){
                return t1;
            }

            if(t1!=null){
                t1 = t1.next;
            }
            t1 = headB;

            if(t2!=null){
                t2 = t2.next;
            }
            t2 = headA;
        }
        return t1;
    }
    public static void main(String[] args) {

        // Common part
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // List A: 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // List B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection Node Value: " + intersection.val);
        } else {
            System.out.println("No Intersection");
        }
    }
}