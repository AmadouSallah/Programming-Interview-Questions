/*
Problem 206. Reverse Linked List

Reverse a singly linked list.
*/

public class ReverseLinkedList {

  public static class ListNode {
    public int val;
    public ListNode next;

    public ListNode (int x) {
      this.val = x;
    }
  }

  // Recursive solution: O(n) runtime and O(n) space complexities
  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode second = reverseList(head.next);
    head.next.next = head;
    head.next = null;

    return head;
  }

  // Iterative solution: O(n) runtime and O(1) space complexities
  public ListNode reverseListIterative(ListNode head) {
    ListNode previous = null, current = head;

    while (current != null) {
      ListNode temp = current.next;
      current.next = previous;
      previous = current;
      current = temp;
    }

    return previous;
  }
}
