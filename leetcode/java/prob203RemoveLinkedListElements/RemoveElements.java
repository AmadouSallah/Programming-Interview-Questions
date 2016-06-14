/*
Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

*/

public class RemoveElements {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode removeElements(ListNode head, int val) {

    if (head == null) return head;

    ListNode temp = new ListNode(0);
    temp.next = head;

    ListNode first = head, second = temp;
    while (first != null) {
      if (first.val == val)
        second.next = first.next;
      else
        second = second.next;

      first = first.next;
    }

    return temp.next;
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
    ListNode node3 = new ListNode(6);
    ListNode node4 = new ListNode(3);
    ListNode node5 = new ListNode(4);
    ListNode node6 = new ListNode(5);
    ListNode node7 = new ListNode(6);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;

    System.out.println("Initially, the linked list is:");
    printList(node1);
    removeElements(node1, 6);
    System.out.println("After removing node with value 6:");
    printList(node1);
  }

}