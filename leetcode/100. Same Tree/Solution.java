public class Solution {
    /**
     * Is same tree.
     * 后续遍历二叉树同时判断每个结点的val是否相等，
     * 使用后续遍历是因为，如果是中序遍历或者前序遍历，
     * 则判断完当前结点是否相等后，后面的语句都是unreachable不可及的。
     *
     * @param p the p
     * @param q the q
     * @return the boolean
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        boolean leftIsSame = isSameTree(p.left, q.left);
        if (!leftIsSame) return false;
        boolean rightIsSame = isSameTree(p.right, q.right);
        if (!rightIsSame) return false;
        if (p.val == q.val) return true;
        else return false;
    }
}
