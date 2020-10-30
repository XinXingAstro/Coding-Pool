import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * Level order list.
     * 层次遍历二叉树，模板代码
     * Time complexity：O(n)
     * Space complexity: O(n)
     *
     * @param root the root
     * @return the list
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode r = q.poll();
                row.add(r.val);
                if (r.left != null) q.offer(r.left);
                if (r.right != null) q.offer(r.right);
            }
            ans.add(row);
        }
        return ans;
    }
}