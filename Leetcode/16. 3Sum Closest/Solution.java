class Solution {
    //Three Move Point
    //Time complexity: O(n^2)
    //Space complexity: O(1)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1, end = n - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(ans - target))
                    ans = sum;
            }
        }
        return ans;
    }
}