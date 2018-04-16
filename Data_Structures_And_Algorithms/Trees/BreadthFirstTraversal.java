import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class BreadthFirstTraversal {

  public static List<Integer> bfs(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    TreeNode current;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      current = queue.poll();
      result.add(current.value);

      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }

    return result;
  }

  private static class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}
