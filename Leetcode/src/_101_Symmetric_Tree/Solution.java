public class Solution {
    /**
     * Is symmetric boolean.
     * 递归方法判断是该树是否是左右对称
     * 不能使用左右遍历的方法判断遍历序列是否相等，左右遍历序列相等的树不一定对称。
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param root the root
     * @return the boolean
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        else if (r1 == null || r2 == null) return false;
        return (r1.val == r2.val)
                && isMirror(r1.left, r2.right)
                && isMirror(r1.right, r2.left);
    }

    /**
     * Is symmetric boolean.
     * 使用队列进行判断，实际运行的时间效率和空间效率都没有递归好。
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param root the root
     * @return the boolean
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode r1 = q.poll();
            TreeNode r2 = q.poll();
            if (r1 == null && r2 == null) continue;
            else if (r1 == null || r2 == null) return false;
            else if (r1.val != r2.val) return false;
            q.add(r1.left);
            q.add(r2.right);
            q.add(r1.right);
            q.add(r2.left);
        }
        return true;
    }
}