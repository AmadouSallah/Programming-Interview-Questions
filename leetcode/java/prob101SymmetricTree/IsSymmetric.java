/*
Problem 101: Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3

Note: Bonus points if you could solve it both recursively and iteratively.

*/
import java.util.Queue;
import java.util.LinkedList;

public class IsSymmetric {

  private static class TreeNode {
   int val;
   TreeNode left, right;
   TreeNode(int x) { val = x; }
  }

    /* Recrusive solution: O(n) run time and O(n) space (in worst case, tree is
      linear => height = n => O(n) space due to stack) */

    public static boolean isSymmetric(TreeNode root) {
        return areMirrors(root, root);
    }

    public static boolean areMirrors(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else {
            return ( (t1.val == t2.val) && areMirrors(t1.left, t2.right) && areMirrors(t1.right, t2.left) );
        }
    }

    // ITERATIVE SOLUTION: O(n) run time and O(n) space
    public static boolean isSymmetric2(TreeNode root) {
      if (root == null) return true;

      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.add(root);
      queue.add(root);
      while(!queue.isEmpty()) {
        TreeNode t1 = queue.poll();
        TreeNode t2 = queue.poll();

        if (t1 == null && t2 == null) {
            continue;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.val != t2.val) {
            return false;
        } else {
          queue.add(t1.left);
          queue.add(t2.right);
          queue.add(t1.right);
          queue.add(t2.left);
        }
      }
      return true;
    }
}