class Solution {
	//双指针法
	//Time complexity: O(n)
	//Space complexity: O(1)
    public int removeDuplicates(int[] nums) {
        int n = nums.length, i = 0;
        for (int j = 1; j < n; j++) {
        	if (nums[i] != nums[j])
        		nums[++i] = nums[j];
        }
        return i + 1;
    }
}