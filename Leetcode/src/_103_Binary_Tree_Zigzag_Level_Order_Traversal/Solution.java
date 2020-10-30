import java.util.*;

public class Solution {
    /**
     * Zigzag level order list.
     * 直接使用层次遍历算法，当遇到偶数行时将数组进行翻转
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param root the root
     * @return the list
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean dir = true;
        while (!q.isEmpty()) {
            int len = q.size();
            dir ^= true;
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode r = q.poll();
                level.add(r.val);
                if (r.left != null) q.offer(r.left);
                if (r.right != null) q.offer(r.right);
            }
            if (dir) ans.add(reverse(level));
            else ans.add(level);
        }
        return ans;
    }
    public List<Integer> reverse(List<Integer> list) {
        int lo = -1, hi = list.size();
        while (++lo < --hi) {
            int temp = list.get(lo);
            list.set(lo, list.get(hi));
            list.set(hi, temp);
        }
        return list;
    }

    /**
     * Zigzag level order list.
     * 递归方式进行之字遍历，徐行速度要快于迭代方法, 代码更加简洁
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param root the root
     * @return the list
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        travel(root, ans, 0);
        return ans;
    }
    public void travel(TreeNode r, List<List<Integer>> ans, int level) {
        if (r == null) return;
        if (ans.size() <= level) ans.add(new LinkedList<>());
        List<Integer> row = ans.get(level);
        if (level%2 == 0) row.add(r.val);
        else row.add(0, r.val);
        travel(r.left, ans, level+1);
        travel(r.right, ans, level+1);
    }
}