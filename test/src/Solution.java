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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        queue.offer(root);
        map.put(root, 1);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int level = queue.size();
            int left = 0, right = 0;
            for (int i = 0; i < level; i++) {
                TreeNode p = queue.poll();
                if (i == 0) left = map.get(p);
                if (i == (level - 1)) right = map.get(p);
                if (p.left != null) {
                    queue.offer(p.left);
                    map.put(p.left, map.get(p) * 2);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                    map.put(p.right, map.get(p) * 2 + 1);
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}