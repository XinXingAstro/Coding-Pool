public class Solution {
    /**
     * Remove duplicates int.
     * 自己编得代码这么复杂，其实remove duplicates是有模板代码。。。
     *
     * @param nums the nums
     * @return the int
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2) return nums.length;
        int du = 0, len = 1, end = nums.length-1;
        for (int i = 1; i <= end; i++) {
            if (nums[i] == nums[i-1]) {
                du++;
                if (du < 2) len++;
            } else {
                du = 0;
                if (len < i) {
                    //将后面所有数往前移动
                    int a = len, b = i;
                    while (b <= end) nums[a++] = nums[b++];
                    end -= (i - len);
                    i = len - 1;
                } else len++;
            }
        }
        return len;
    }

    /**
     * Remove duplicates int.
     * 最后返回的数组中允许有最多两个重复，模板代码。
     * Time complexiy: O(n)
     * Space complexiy: O(1)
     *
     * @param nums the nums
     * @return the int
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        }
        return i;
    }
}
