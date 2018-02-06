/*
Add Two Numbers:

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

  public static void printList(ListNode ln) {
    ListNode node = ln;
    while (node != null) {
      System.out.print(node.val + " => ");
      node = node.next;
    }

    System.out.println("null");
  }


  public static void main(String[] args) {
    // ListNode l1 = new ListNode(0);
    // ListNode l2 = new ListNode(0);
    // ListNode l3 = new ListNode(5);
    // ListNode l4 = new ListNode(5);
    // ListNode l5 = new ListNode(7);

    ListNode p1 = new ListNode(2);
    ListNode p2 = new ListNode(4);
    ListNode p3 = new ListNode(3);
    ListNode p4 = new ListNode(5);
    ListNode p5 = new ListNode(6);
    ListNode p6 = new ListNode(4);
    p1.next = p2;
    p2.next = p3;
    p4.next = p5;
    p5.next = p6;
    ListNode ln1 = p1, ln2 = p4;

    System.out.print("ln1: ");
    printList(ln1);
    System.out.print("ln2: ");
    printList(ln2);
    System.out.print("ln1 + ln2: ");
    printList(addTwoNumbers(ln1, ln2));
    // printList(addTwoNumbers(l1, l2)); // 0 => null
    // printList(addTwoNumbers(l3, l4)); // 0 => 1 => null
    // printList(addTwoNumbers(l1, l3)); // 5 => null
    // printList(addTwoNumbers(l3, l5)); // 2 => 1 => null
    //
    // printList(addTwoNumbers(ln1, ln2)); // 7 => 0 => 8 => null
  }
}
