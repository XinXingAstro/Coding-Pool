import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean dir = false;
        while (!q.isEmpty()) {
            int len = q.size();
            dir ^= true;
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode r = dir ? q.pollFirst() : q.pollLast();
                row.add(r.val);
                if (dir) {
                    if (r.left != null) q.offer(r.left);
                    if (r.right != null) q.offer(r.right);
                } else  {
                    if (r.right != null) q.offer(r.right);
                    if (r.left != null) q.offer(r.left);

                }
            }
            ans.add(row);
        }
        return ans;
    }
}