import java.util.*;

public class Solution {
    /**
     * Sorted array to bst tree node.
     * 根据有序数组新建搜索二叉树，二叉树基本功，需要背诵。
     * Time complexity: O(N)
     * Space complexity: O(N)
     *
     * @param nums the nums
     * @return the tree node
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        TreeNode r = new TreeNode(nums[mid]);
        r.left = helper(nums, lo, mid-1);
        r.right = helper(nums, mid+1, hi);
        return r;
    }
}