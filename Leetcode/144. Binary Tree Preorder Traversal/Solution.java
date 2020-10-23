import java.util.*;

public class Solution {
    /**
     * Preorder traversal list.
     * 树得先根遍历，模板算法
     * Time complexity: O(N)
     * Space compelexity: O(1)
     *
     * @param root the root
     * @return the list
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }
    public void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}