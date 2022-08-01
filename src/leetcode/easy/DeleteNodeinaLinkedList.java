package leetcode.easy;

/**
 * 237. Delete Node in a Linked List
 */
public class DeleteNodeinaLinkedList {

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
}
