import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * Level order bottom list.
     * 使用层次遍历的方法，直接在ans的前面加入每行的遍历结果既可。
     * Time complexity: O(N)
     * Space complexity: O(N)
     *
     * @param root the root
     * @return the list
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode r = q.poll();
                row.add(r.val);
                if (r.left != null) q.offer(r.left);
                if (r.right != null) q.offer(r.right);
            }
            ans.add(0, row);
        }
        return ans;
    }
}