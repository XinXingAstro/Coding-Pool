import java.util.*;

public class Solution {
    /**
     * Postorder traversal list.
     * 二叉树的后序遍历，模板代码
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * @param root the root
     * @return the list
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }
    public void postorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}