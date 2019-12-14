import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Is valid bst Tree.
     * 先中序遍历BST，之后判断数组中的数字是否有逆序数。
     *
     * @param root the root
     * @return the boolean
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> list = new ArrayList<>();
        inWalk(root, list);
        int n = list.size(), a = list.get(0), b = 0;
        for (int i = 1; i < n; i++) {
            b = list.get(i);
            if (b <= a) return false;
            a = b;
        }
        return true;
    }
    public void inWalk(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inWalk(root.left, list);
        list.add(root.val);
        inWalk(root.right, list);
    }

    /**
     * Is valid bst Tree.
     * 一边遍历BST一边判断是否Valid
     *
     * @param root the root
     * @return the boolean
     */
    public boolean ans = true;
    public int preNode = -1;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        ans &= isValidBST(root.left);
        if (preNode == -1 || root.val > preNode) preNode = root.val;
        else return false;
        ans &= isValidBST(root.right);
        return ans;
    }

    /**
     * Is valid bst Tree.
     * 一边遍历BST一边判断是否Valid
     * 减少一个全局变量
     *
     * @param root the root
     * @return the boolean
     */
    public int preNode = -1;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean leftIsValid = isValidBST(root.left);
        if (!leftIsValid) return false;
        if (preNode == -1 || root.val > preNode) preNode = root.val;
        else return false;
        boolean rightIsValid = isValidBST(root.right);
        if (!rightIsValid) return false;
        return true;
    }
}
