import java.util.*;

public class Solution {
    /**
     * Path sum list.
     * 记录所有路径几点和等于sum的路径，模板代码
     *
     * @param root the root
     * @param sum  the sum
     * @return the list
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, sum, ans, path);
        return ans;
    }
    public void helper(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        } else {
            helper(root.left, sum-root.val, ans, path);
            helper(root.right, sum-root.val, ans, path);
        }
        path.remove(path.size() - 1);
    }
}