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

    /**
     * Remove duplicates int.
     * 生成的数组中不允许有重复数字，模板代码。
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param nums the nums
     * @return the int
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 1 || n > nums[i-1])
                nums[i++] = n;
        }
        return i;
    }
}