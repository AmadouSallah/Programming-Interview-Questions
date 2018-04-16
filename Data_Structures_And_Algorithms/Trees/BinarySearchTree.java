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

    public static boolean search(int value) {

      Node current = root;
      while (current != null) {
        if (current.data == value) {
          return true;
        } else if (value < current.data) {
          current = current.left;
        } else {
          current = current.right;
        }
      }
      return false;
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

  public static Node getMin(Node node) {
    Node current = node;
    while (current.left != null) {
      current = current.left;
    }
    return current;
  }

  public static Node getMax(Node node) {
    Node current = node;
    while (current.right != null) {
      current = current.right;
    }
    return current;
  }

  public static void delete(int key) {
    root = deleteNode(root, key);
  }

  private static Node deleteNode(Node root, int key) {
    if (root == null) {
      return root;
    }

    if (key < root.data) {
      root.left = deleteNode(root.left, key);
    } else if (key > root.data) {
      root.right = deleteNode(root.right, key);
    } else { // key = root.data
      // case 1 & 2: node to be deleted has 0 or 1 child
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else { // case 3: node to be deleted has 2 children. We then replace it by
        // the successor node, which is the node with the minimum value to the right
        // (or by the node with the largest value to the left)
        Node successorNode = getMin(root.right);

        // replace the value of root with that of its successor
        root.data = successorNode.data;
        // delete the successor node
        root.right = deleteNode(root.right, successorNode.data);
      }
    }
    return root;
  }

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(3);
    bst.insert(5);
    bst.insert(1);
    bst.insert(6);
    bst.insert(2);
    bst.insert(0);
    bst.insert(-1);

    printInorderTraversal(bst.root);
    System.out.println();

    System.out.println("minimum value = " + bst.getMin(bst.root).data);
    System.out.println("maximum value = " + bst.getMax(bst.root).data);

    System.out.println("\nsearch(3): " + search(3));
    System.out.println("search(10): " + search(10) + "\n");

    System.out.println("Deleting node with value -1 (has no children):");
    bst.delete(-1);
    printInorderTraversal(bst.root);
    System.out.println();

    System.out.println("Deleting node with value 5 (has only 1 child):");
    bst.delete(5);
    printInorderTraversal(bst.root);
    System.out.println();

    System.out.println("Deleting node with value 1 (has 2 children):");
    bst.delete(1);
    printInorderTraversal(bst.root);
    System.out.println();
  }

}
