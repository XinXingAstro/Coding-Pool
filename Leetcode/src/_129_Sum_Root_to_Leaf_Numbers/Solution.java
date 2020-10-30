import java.util.*;

public class Solution {
    /**
     * Sum numbers int.
     * 笨方法，先遍历出所有路径，然后将路径代表的数相加。
     * Time complexity: O(N)
     * Spcae complexity: O(1)
     *
     * @param root the root
     * @return the int
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<List<Integer>> path = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        preorder(root, list, path);
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            List<Integer> l = path.get(i);
            int len = l.size();
            for (int j = len-1; j >= 0; j--) {
                int n = l.get(j);
                sum += n * Math.pow(10, len-1-j);
            }
        }
        return sum;
    }
    public void preorder(TreeNode root, List<Integer> list, List<List<Integer>> path) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            path.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        preorder(root.left, list, path);
        preorder(root.right, list, path);
        list.remove(list.size()-1);
    }

    /**
     * Sum numbers int.
     * 一边遍历一边相加的解法。
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * @param root the root
     * @return the int
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return preorder(root, 0);
    }
    public int preorder(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            sum = sum * 10 + root.val;
            return sum;
        }
        sum = sum * 10 + root.val;
        return preorder(root.left, sum) + preorder(root.right, sum);
    }
}