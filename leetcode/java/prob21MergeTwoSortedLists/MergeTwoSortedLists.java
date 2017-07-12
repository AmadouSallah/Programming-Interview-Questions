/*
Resource: https://leetcode.com/problems/merge-two-sorted-lists/#/description

Problem 21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing
together the nodes of the first two lists.

*/

public class MergeTwoSortedLists {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }
  }

  // Recursive solution
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  // Iterative solution
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) return null;
    else if (l1 == null) return l2;
    else if (l2 == null) return l1;

    ListNode curr = new ListNode(0);
    ListNode node = curr;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
          curr.next = l2;
          l2 = l2.next;
      }
      curr = curr.next;
    }

    if (l1 != null) curr.next = l1;
    if (l2 != null) curr.next = l2;

    return node.next;
  }
}
