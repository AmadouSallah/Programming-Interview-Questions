/*
Leetcode Problem 445. Add Two Numbers II
https://leetcode.com/problems/add-two-numbers-ii/description/

You are given two non-empty linked lists representing two non-negative integers.
The most significant digit comes first and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/

import java.util.Stack;

public class AddTwoNumbersII {

  public static class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();

    while (l1 != null) {
      s1.push (l1.val);
      l1 = l1.next;
    }

    while (l2 != null) {
      s2.push (l2.val);
      l2 = l2.next;
    }

    ListNode head = null;
    int carry = 0, sum;

    while (carry != 0 || !s1.isEmpty() || !s2.isEmpty()) {
      sum = carry; // reset sum to carry
      if (!s1.isEmpty()) sum += s1.pop();
      if (!s2.isEmpty()) sum += s2.pop();

      carry = sum / 10;
      ListNode node = new ListNode(sum % 10);
      node.next = head;
      head = node;
    }
    return head;
  }
}
