/*
Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.
*/

public class RemoveNthFromEnd {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode tempNode = new ListNode(0);
    tempNode.next = head;
    ListNode firstNode = tempNode, secondNode = tempNode;
    int i = 0;

    while (i < n) {
      firstNode = firstNode.next;
      i++;
    }

    while (firstNode.next != null) {
      firstNode = firstNode.next;
      secondNode = secondNode.next;
    }

    secondNode.next = secondNode.next.next;

    return tempNode.next;
  }

  public static void printList(ListNode head) {
    if (head == null) return;
    ListNode node = head;
    while (node != null) {
      System.out.print(node.val + " -> ");
      node = node.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = null;

    System.out.println("Initially, the list is:");
    printList(node1);
    removeNthFromEnd(node1, 2);
    System.out.println("\nAfter calling removeNthFromEnd(node1, 2), the list becomes:");
    printList(node1);
  }

}