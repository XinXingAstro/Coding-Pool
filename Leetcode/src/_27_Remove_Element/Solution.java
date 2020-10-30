class Solution {
	//双指针法
	//Time complexity: O(n)
	//Space complexity: O(1)
    public int removeElement(int[] nums, int val) {
        int n = nums.length,i = -1;
        for (int j = 0; j < n; j++) {
        	if (nums[j] != val) {
        		nums[++i] = nums[j];
        	}
        }
        return i + 1;
    }
}