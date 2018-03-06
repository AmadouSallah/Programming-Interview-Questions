public class BinarySearchTree {

    public static Node root;
    public static int size;

    public BinarySearchTree() {
      root = null;
      size = 0;
    }

    public static void insert(int value) {
      Node newNode = new Node(value);
      if (root == null) {
        root = newNode;
        size++;
        return;
      }

      Node current = root, parent;
      while (current != null) {
        parent = current;
        if (value < current.data) {
          current = current.left;
          if (current == null) {
            parent.left = newNode;
            break;
          }
        } else {
          current = current.right;
          if (current == null) {
            parent.right = newNode;
            break;
          }
        }
      }
      size++;
    }


    public static void printInorderTraversal(Node node) {
      if (node == null) {
        return;
      }
      printInorderTraversal(node.left);
      System.out.print(node.data + " ");
      printInorderTraversal(node.right);
    }

  private static class Node {
    int data;
    Node left, right;

    public Node(int data) {
      this.data = data;
    }
  }

  public static int getMin(Node node) {
    Node current = node;
    while (current.left != null) {
      current = current.left;
    }
    return current.data;
  }

  public static int getMax(Node node) {
    Node current = node;
    while (current.right != null) {
      current = current.right;
    }
    return current.data;
  }

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(3);
    bst.insert(5);
    bst.insert(1);
    bst.insert(6);
    bst.insert(2);
    bst.insert(0);

    printInorderTraversal(bst.root);
    System.out.println();

    System.out.println("minimum value = " + bst.getMin(bst.root));
    System.out.println("maximum value = " + bst.getMax(bst.root));
  }

}
