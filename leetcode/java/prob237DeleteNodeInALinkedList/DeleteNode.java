/*

Delete Node in a Linked List

Write a function to delete a node (except the tail) in a singly linked list,
given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node
with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

*/

public class DeleteNode {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
  }

  public static void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
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

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    System.out.print("Initially, the list is: ");
    printList(node1);
    deleteNode(node3);
    System.out.print("After deleting the node of value 3, the list becomes: ");
    printList(node1);
  }
}