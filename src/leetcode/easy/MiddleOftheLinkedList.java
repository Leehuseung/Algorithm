package leetcode.easy;

/**
 * 876. Middle of the Linked List
 */
public class MiddleOftheLinkedList {

    public ListNode middleNode(ListNode head) {
//        LinkedList<ListNode> list = new LinkedList();
//        list.add(head);
//        while(head.next != null){
//            list.add(head.next);
//            head = head.next;
//        }
//        int i = list.size()/2;
//        if(list.size() % 2 == 1){
//            i++;
//        }
//        return list.get(i);

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(slowPointer.next != null && fastPointer.next.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(5/2);
        System.out.println(6/2);
    }
}
