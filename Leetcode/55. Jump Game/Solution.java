public class Solution {
    /**
     * 贪心算法
     * Time complexiy: O(N)
     *
     *
     * @param nums the nums
     * @return the boolean
     */
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= lastPos) lastPos = i;
        }
        return lastPos == 0;
    }

    /**
     * 回溯算法
     * 效率很低，一种优化方法如下
     * // Old
     * for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++)
     * // New
     * for (int nextPosition = furthestJump; nextPosition > position; nextPosition--)
     * Time complexity: O(2^n)
     *
     * @param nums the nums
     * @return the boolean
     */
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }
}
