class Solution {
    /**
     * 升序数组延某位置一转轴翻转之后，在其上进行搜索
     * BinarySearch + 区间判断
     * 将数组按照转轴分为两部分，每次判断mid指针位于转轴的左侧还是右侧
     * Time complexity: O(logN)
     *
     * @param nums   the nums sorted in ascending order
     *              is rotated at some pivot unknown to you beforehand.
     * @param target the target
     * @return the int
     */
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target < nums[mid]) {
                //如果mid指针位于左半区，并且target<nums[lo]，说明target在右边
                if (nums[mid] > nums[hi] && target < nums[lo]) lo = mid + 1;
                else hi = mid - 1;
            } else if (target > nums[mid]) {
                //如果mid指针位于右半区
                if (nums[mid] < nums[lo] && target > nums[hi]) hi = mid - 1;
                else lo = mid + 1;
            } else return mid;
        }
        return -1;
    }
}