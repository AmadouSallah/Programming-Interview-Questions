/*

printPaths()

Given a binary tree, print out all of its root-to-leaf paths, one per line.
Example, for the tree below:
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \      \
  7    2      1
The root-to-leaf paths are:
 5 4 11 7
 5 4 11 2
 5 8 13
 5 8 4 1
*/

 package treesPackage;

 public class Prob8PrintPaths {

  public static void printPaths(Node root) {
    int[] pathsArray = new int[1000];
    printPaths(root, pathsArray, 0);
  }

  private static void printPaths(Node root, int[] pathsArray, int index) {

    if (root == null) return;

    pathsArray[index++] = root.getData();

    if (root.getLeftChild() == null && root.getRightChild() == null) {
      printArray(pathsArray, index);
      return;
    }  else {
      printPaths(root.getLeftChild(), pathsArray, index);
      printPaths(root.getRightChild(), pathsArray, index);
    }

  }

  public static void printArray(int[] arr, int len) {
    for (int i = 0; i < len; i++)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    /*
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1

    */
    Node node1 = new Node(5);
    Node node2 = new Node(4);
    Node node3 = new Node(8);
    Node node4 = new Node(11);
    Node node5 = new Node(13);
    Node node6 = new Node(4);
    Node node7 = new Node(7);
    Node node8 = new Node(2);
    Node node9 = new Node(1);

    node1.setLeftChild(node2);
    node1.setRightChild(node3);

    node2.setLeftChild(node4);

    node3.setLeftChild(node5);
    node3.setRightChild(node6);

    node4.setLeftChild(node7);
    node4.setRightChild(node8);

    node6.setRightChild(node9);

    printPaths(node1);
  }
 }