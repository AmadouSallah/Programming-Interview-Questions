/*
Leetcode Prob82 Remove Duplicates From SortedList II
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.

Example 1:
Input: 1->2->3->3->4->4->5
Output: 1->2->5

Example 2:
Input: 1->1->1->2->3
Output: 2->3
*/

public class RemoveDuplicatesFromSortedListII {

  public static class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public static ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null && current.next.next != null) {
      if (current.next.val == current.next.next.val)  {
        int dupVal = current.next.val;
        while (current.next != null && current.next.val == dupVal) {
          current.next = current.next.next;
        }
      } else {
        current = current.next;
      }
    }
    return dummy.next;
  }
}
