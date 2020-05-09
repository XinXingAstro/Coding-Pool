/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i] += nums[i];
            if (sum[i] == k) ans++;
        }
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                temp = sum[j] - sum[i-1];
                if (temp == k) ans++;
            }
        }
        return ans;
    }
}