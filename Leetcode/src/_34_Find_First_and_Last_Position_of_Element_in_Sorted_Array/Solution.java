public class Solution {
    /**
     * 在一个排好序的有重复数字的数组中查找目标的起始和终止位置。
     * 用二分查找找到第一个位置，然后左边用二分查找找到起始位置，
     * 右边用二分查找找到终止位置
     * Time complexity: O(logN)
     *
     * @param nums   the nums
     * @param target the target
     * @return the int [ ]
     */
    public int[] searchRange(int[] nums, int target) {
        int mid = indexOf(nums, target, 0, nums.length - 1);
        int left = mid, right = mid, index;
        if (mid == -1) return new int[]{-1, -1};
        else {
            //find first
            for (index = indexOf(nums, target, 0, mid - 1);
                 index != -1;
                 index = indexOf(nums, target, 0, left - 1)) {
                left = index;
            }
            //find last
            for (index = indexOf(nums, target, mid + 1, nums.length - 1);
                 index != -1;
                 index = indexOf(nums, target, right + 1, nums.length - 1)) {
                right = index;
            }
            return new int[]{left, right};
        }
    }

    /**
     * BinarySearch
     *
     * @param a   the a 数组
     * @param key the key 查找目标
     * @param lo  the lo 查找起始位置
     * @param hi  the hi 查找终止位置
     * @return the int
     */
    public int indexOf(int[] a, int key, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
