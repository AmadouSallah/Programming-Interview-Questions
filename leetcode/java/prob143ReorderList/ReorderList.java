/*
https://leetcode.com/problems/reorder-list/description/

Problem 143. Reorder List

Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

/*
Resources:
https://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
https://leetcode.com/problems/reorder-list/discuss/45147/Java-solution-with-3-steps

1) Split the linked list in two halves using found middle point in step 1.
2) Reverse the second half.
3) Do alternate merge of first and second halves.
*/
public class ReorderList {

  public static class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
      val = x;
    }
  }

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;

    // Step 1: Split the list in 2 halves: 1st half goes from head to prev and 2nd half from slow to end
    ListNode prev = null, slow = head, fast = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null; // the end of the first half

    // Step 2: reverse 2nd half and assign to l2.
    ListNode l1 = head, l2 = reverse(slow);

    // Step 3: do alternate merge of l1 and l2 and assign result to head
    head = alternateMerge(l1, l2);
  }

  public ListNode reverse(ListNode head) {
    ListNode previousNode = null, currentNode = head;
    while (currentNode != null) {
      ListNode nextNode = currentNode.next;
      currentNode.next = previousNode;
      previousNode = currentNode;
      currentNode = nextNode;
    }
    return previousNode;
  }

  public ListNode alternateMerge(ListNode l1, ListNode l2) {
    ListNode node = new ListNode(0), current = node;
    while (l1 != null || l2 != null) {
      if (l1 != null) {
        current.next = l1;
        current = current.next;
        l1 = l1.next;
      }
      if (l2 != null) {
        current.next = l2;
        current = current.next;
        l2 = l2.next;
      }
    }
    return node.next;
  }
}
