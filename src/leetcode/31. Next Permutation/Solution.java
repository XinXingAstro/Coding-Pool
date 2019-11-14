public class Solution {
    /**
     * Next permutation.
     * 生成全排列的字典序算法，背诵！
     * 算法步骤：
     * 1）从右向左找到第一个非递增元素
     * 2）从右向左找到第一个比非递增元素大的元素
     * 3）交换这两个元素
     * 4）将非递增位置后面的元素翻转
     *
     * @param nums the nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到第一个非递增元素
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            //从右向左找到第一个比非递增元素大的元素
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j); //交换这两个元素
        }
        reverse(nums, i + 1); //将后面的部分翻转
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
