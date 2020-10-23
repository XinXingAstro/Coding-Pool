public class Solution {
    /**
     * 在排序数组中找到一个数的插入位置
     * 二分查找+最后判断插入位置
     * 因为二分查找如果数不在数组中，最后mid的位置是数组中最接近target的数的位置，
     * 不能直接返回mid，必须在最后做判断一下target和nuns[mid]的大小来确定插入位置。
     * Time complexity: O(logN)
     *
     * @param nums   the nums
     * @param target the target
     * @return the int
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int lo = 0, hi = nums.length - 1, mid = (lo + hi) / 2;;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (target > nums[mid]) lo = mid + 1;
            else if (target < nums[mid]) hi = mid - 1;
            else return mid;
        }
        //mid最后指向的位置是最接近target的数的位置
        return target <= nums[mid] ? mid : mid + 1;
    }
}
