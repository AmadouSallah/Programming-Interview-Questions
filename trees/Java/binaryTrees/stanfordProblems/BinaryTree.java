package stanfordPackage;

public class BinaryTree {

  private Node root;

  public BinaryTree(Node root) {
    this.root = root;
  }

  public Node getRoot() {
    return root;
  }

  // Create an empty binary tree -- a root pointer
  public void BinaryTree() {
    root = null;
  }

  /*
  Returns true if the given target is in the binary tree.
  Uses a recursive helper
  */
  public boolean lookup(int data) {
    return lookup(root, data);
  }

  // Recursive lookup: given a node, recur down searching for the given data
  private boolean lookup(Node node, int data) {

    if (node == null) return false;

    if (data == node.getData()) {
      return true;
    } else if (data < node.getData()) {
      return  lookup(node.getLeftChild(), data);
    } else {
      return lookup(node.getRightChild(), data);
    }

  }

  // Inserts the given data into the binary tree. Uses a recursive helper
  public void insert(int data) {
    root = insert(root, data);
  }

  /* Recursive insert -- Given a node pointer, recur down and
  insert the given data into the tree. Returns the node pointer
  */
  public Node insert(Node node, int data) {

    if (node == null) return new Node(data);

    if (data <= node.getData()) {
      node.setLeftChild(insert(node.getLeftChild(), data));
    } else {
      node.setRightChild(insert(node.getRightChild(), data));
    }

    return node;
  }

}