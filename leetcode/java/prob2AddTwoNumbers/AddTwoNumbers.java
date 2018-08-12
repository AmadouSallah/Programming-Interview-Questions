/*
Leetcode Problem 2: Add Two Numbers:

https://leetcode.com/problems/add-two-numbers/discuss/159284/Adding-my-Java-solution

You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {val = x;}
}

public class AddTwoNumbers {

  /* O(max(n1, n2) runtime and O(max(n1, n2) space complexities, where
  n1 and n2 are the respective lengths of l1 and l2 */
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    int carry = 0, sum;
    ListNode head = new ListNode(0);
    ListNode ln1 = l1, ln2 = l2, node = head;

    while (carry != 0 || ln1 != null || ln2 != null) {

      sum = carry; // reset sum to the value of carry

      if (ln1 != null) {
        sum += ln1.val;
        ln1 = ln1.next;
      }
      if (ln2 != null) {
        sum += ln2.val;
        ln2 = ln2.next;
      }

      carry = sum / 10;
      node.next = new ListNode(sum % 10);
      node = node.next;
    }
    
    return head.next;
  }

  public static String printList(ListNode head) {
    ListNode current = head;
    String result = "";

    while (current != null) {
      result += current.val + " -> ";
      current = current.next;
    }

    result += "null";
    return result;
  }

  public static void main(String[] args) {

    ListNode node1 = new ListNode(2);;
    node1.next = new ListNode(4);
    node1.next.next = new ListNode(3);

    ListNode node2 = new ListNode(5);;
    node2.next = new ListNode(6);
    node2.next.next = new ListNode(4);

    System.out.println("node1: " + printList(node1));
    System.out.println("node2: " + printList(node2));
    System.out.println("node1 + node2: " + printList(addTwoNumbers(node1, node2)));
  }
}
