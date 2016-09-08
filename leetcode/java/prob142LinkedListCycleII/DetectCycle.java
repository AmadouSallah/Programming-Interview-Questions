/*
Problem 142: Linked List Cycle II

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/


/*
    PSEUDOCODE

Resources: Cracking the Coding interview by Gayle Laakmann McDowell

If either the input 'head' or its next is null, this would mean that there
can't be a cycle. We therefore return null.

We declare and set to head 2 pointers 'fast' and 'slow'. We also declare a
boolean variable 'hasCycle' and initially set it to false. It will only be set
to true when we find a cycle in the linked list.

We then do the followings:

1) Find the collision point if any.
  We iterate in a while loop as long as 'fast' and its next pointer are not null.
  In each iteration, we move slow by a rate of 1 step and fast by a rate of 2 steps.
  We then compare them. If 'fast' is the same as 'slow', then we have found the collision
  point. We set 'hasCycle' to true and break out of the while loop.

2) Error check:
  if there is no collision point, that is 'fast' or fast.next is null
  (this means hasCycle is still false), we return null

3) Move slow to head and keep fast at the collision point. Each of them is k steps
  from the beginning of the loop. If they move at the same pace, they must meet at the
  beginning of the loop

4) Return either one of them (they both point to the beginning of the loop).

*/
public class DetectCycle {
  private class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public static ListNode detectCycle(ListNode head) {

    if (head == null || head.next == null) return null;

    ListNode fast = head, slow = head;
    boolean hasCycle = false;

    // Finding the collision point
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (fast == slow) { // collision point
        hasCycle = true;
        break;
      }
    }

    // Error check: if there is no meeting point, then there will be no loop
    if (hasCycle == false) return null;

    // Move slow to head and keep fast at the collision point. Move them at the same pace
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }
}