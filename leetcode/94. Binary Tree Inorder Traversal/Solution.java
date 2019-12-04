import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Inorder traversal list.
     * 中序遍历二叉树，模板代码
     *
     * @param root the root
     * @return the list
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inWalk(root, ans);
        return ans;
    }
    public void inWalk(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        inWalk(node.left, ans);
        ans.add(node.val);
        inWalk(node.right, ans);
    }
}
