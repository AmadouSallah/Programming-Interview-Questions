/*
Problem 83: Remove Duplicates from Sorted List

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

*/

public class DeleteDuplicates {

  public static class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode node = head;
    while (node != null && node.next != null) {
      if (node.val == node.next.val)
        node.next = node.next.next;
      else
        node = node.next;
    }
    return head;
  }
}