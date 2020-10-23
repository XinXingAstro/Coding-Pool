import java.util.*;

public class Solution {
    /**
     * Is balanced boolean.
     * Time complexity: O(N^2)
     * Space complexity: O(N)
     *
     * @param root the root
     * @return the boolean
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }


    public boolean isBalanced(TreeNode root) {
        return depth(root) == -1 ? false : true;
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}