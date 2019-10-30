public class Solution {
    /**
     * Max sub array int.
     * 如果sum+nums[i]后的结果比nums[i]小，则从nums[i]处重新开始加，
     * 并实时记录最大的sum。
     * Time complexity: O(N)
     *
     * @param nums the nums
     * @return the int
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //如果sum+nums[i]后的结果比nums[i]小，则从nums[i]处重新开始加
            if (sum < nums[i]) sum = nums[i];
            if (maxSum < sum) maxSum = sum;
        }
        return maxSum;
    }
}
