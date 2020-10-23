import java.util.*;

public class Solution {
    /**
     * Flatten.
     * 将二叉树展平，模板代码
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * @param root the root
     */
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}