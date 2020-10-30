public class Solution {
    /**
     * Search boolean.
     * 指针控制太难了，背诵
     *
     * @param nums   the nums
     * @param target the target
     * @return the boolean
     */
    public boolean search(int[] nums, int target) {
        // note here hi is initialized to len instead of (len-1)
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[lo]) { // nums[lo..mid] is sorted
                // check if target in left half
                if (target < nums[mid] && target >= nums[lo]) hi = mid;
                else lo = mid + 1;
            } else if (nums[mid] < nums[lo]) { // nums[mid..hi] is sorted
                // check if target in right half
                if (target > nums[mid] && target < nums[lo]) lo = mid + 1;
                else hi = mid;
            } else { // have no idea about the array, but we can exclude nums[lo] because nums[lo] == nums[mid]
                lo++;
            }
        }
        return false;
    }
}
