class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Three Move Point
        //Time complexity: O(n^2)
        //Space complexity: O(1)
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (n - 2); i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;
                    while (j < k && nums[j] == nums[j - 1]) j++; //去重
                    while (k > j && nums[k] == nums[k + 1]) k--; //去重
                } else if (sum < 0) j++;
                else k--;
            }
        }
        return ans;
    }
}