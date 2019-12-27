import java.util.*;

public class Solution {
    /**
     * Min depth int.
     * 找到树的最小深度，模板代码
     *
     * @param root the root
     * @return the int
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left), right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}