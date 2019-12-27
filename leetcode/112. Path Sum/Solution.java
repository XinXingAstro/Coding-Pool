import java.util.*;

public class Solution {
    /**
     * Has path sum boolean.
     * 找到二叉树中有没有路径上节点和等于sum的路径，模板代码
     *
     * @param root the root
     * @param sum  the sum
     * @return the boolean
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum - root.val == 0) return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}