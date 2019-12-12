import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Generate trees list.
     * 递归算法生成搜索二叉树
     *
     * @param n the n
     * @return the list
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return genTrees(1, n);
    }
    public List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        } else if (start == end) {
            list.add(new TreeNode(start));
            return list;
        } else {
            List<TreeNode> left, right;
            for (int i = start; i <= end; i++) {
                left = genTrees(start, i - 1);
                right = genTrees(i + 1, end);
                for (TreeNode lnode : left) {
                    for (TreeNode rnode: right) {
                        TreeNode root = new TreeNode(i);
                        root.left = lnode;
                        root.right = rnode;
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }
}
