/*
This is a very basic problem with a little pointer manipulation.
(You can skip this problem if you are already comfortable with pointers.)

Write code that builds the following little 1-2-3 binary search tree...
  2
 / \
1   3

Write the code in three different ways...
  a: by calling newNode() three times, and using three pointer variables
  b: by calling newNode() three times, and using only one pointer variable
  c: by calling insert() three times passing it the root pointer to build up the tree
*/

package stanfordPackage;

public class Prob1Build123 {

  // Build 123 using three pointer variables.
  public void build123a() {
    Node root = new Node(2);
    Node left = new Node(1);
    Node right = new Node(3);

    root.setLeftChild(left);
    root.setRightChild(right);
  }

  // Build 123 using only one pointer variable.
  public void build123b() {
    Node root = new Node(2);
    root.setLeftChild(new Node(1));
    root.setRightChild(new Node(3));
  }

}




