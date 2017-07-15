/*
Resource: https://leetcode.com/problems/merge-k-sorted-lists/#/description

Problem 23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

import java.util.Arrays;

public class MergeKSortedLists {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;

    int n = lists.length;
    if (n == 1) {
      return lists[0];
    } else if (n == 2) {
      return mergeTwoLists(lists[0], lists[1]);
    } else {
      int mid = n/2;
      ListNode left = mergeKLists(Arrays.copyOfRange(lists, 0, mid));
      ListNode right = mergeKLists(Arrays.copyOfRange(lists, mid, n));

      return mergeTwoLists(left, right);
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
