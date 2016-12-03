/*
Problem 160. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.


Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/*
 Solution 1: Brute Force (Time Limit Exceeded)
 O(n1*n2) runtime and O(1) space complexities, where n1 is the length of headA and n2 that of headB

 Solution 2: Using a hash:
 Traverse the 1st list and store the address reference to each node in a hash set. Then check every node in the 2nd list;
 if it appears in the hash set, then this node is the intersection node.
 O(n1 + n2) runtime and O(n1) or O(n2) space complexities

 Solution 3: Using 2 pointers:
 1) If either headA or headB is null, we return null
 2) We use 2 pointers node1 and node1 that we initialize to headA and headB respectively.
 3) We make node1 and node2 traverse the lists one step at a time, as long as they are not equal.

 There will be a total of 2 iterations for each of them:
 When node1 (respectively node2) reaches the tail of a list1, we reset it to headB (respectively headA). In total, each
 of them will be reset to the head of the other once, therefore 2 iterations for each of them.
 They will intersect during their 2nd iteration, and at that point, we return one of them.

 Note that if the 2 lists don't intersect, then they both reach the tail nodes at the same time on the 2nd iteration,
 so they both become null. That means they are equal and null is returned.

 Example:
 list1 = {a1, a2, c1, c2} and list2 = {b1, b2, b3, b4, c1, c2}. So headA = a1 and headB = b1.
 Initially, we make node1 points to a1 and node2 points to b1.

 We iterate as long as node1 is not equal to node2, incrementing both of them 1 step at a time.
 Since list1 is the shorter list, node1 will reach the end 1st.
 By the time node1 reaches the end (null), node2 will be at c1. We then reset node1 to point to headB, which is b1.
 Now node1 points to b1 and node2 points to c1.

 We continue the iteration, which corresponds to the 2nd iteration of node1 but still 1st iteration of node2
 By the time node2 reaches the end, node1 will be at b3. We then reset node2 to point to a1.
 Now node1 points to b3 and node2 points to a1.

 We continue the iteration, which corresponds to the 2nd iteration of node1 and 2nd iteration of node2.
 After 2 more steps, both node1 and node2 will meet at c1. We then return this node, which is the point of intersection :)
 */