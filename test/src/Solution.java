/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public Map<Integer, Integer> map = new HashMap<>();
    public int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == max) list.add(i);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
    public int postorder(TreeNode root) {
        if (root == null) return 0;
        int left = postorder(root.left);
        int right = postorder(root.right);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}